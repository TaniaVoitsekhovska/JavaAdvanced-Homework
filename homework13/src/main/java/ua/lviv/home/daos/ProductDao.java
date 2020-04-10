package ua.lviv.home.daos;

import org.apache.log4j.Logger;
import ua.lviv.home.EntityManagerUtils;
import ua.lviv.home.enteties.Product;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDao implements CRUD<Product> {

    private static final Logger LOG = Logger.getLogger(ProductDao.class);

    private static String READ_ALL = "select p from Product p";
    private static String READ_ALL_IN = "select p from Product p where p.id in (:productIds)";
    private static String READ_BY_ID = "select p from Product p where p.id =:id";
    private static String UPDATE_BY_ID = "update Product p set p.name=:name, p.description = :description," +
            " p.price = :price where p.id = :id";

    public ProductDao() {
    }


    @Override
    public Product insert(Product product) {
        String message = String.format("Will create a product with name=%s",
                product.getName());
        LOG.debug(message);
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return product;
        } catch (Exception e) {
            String errorMessage = String.format("Fail to create a product for productId=%d",
                    product.getId());
            LOG.error(errorMessage, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product read(int id) {
        Product product;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            product = entityManager.createQuery(READ_BY_ID, Product.class)
                    .setParameter("id", id)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            return product;
        } catch (Exception e) {
            String errorMessage = String.format("Fail to get a product with id=%d", id);
            LOG.error(errorMessage, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product, int id) {

        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery(UPDATE_BY_ID)
                    .setParameter("id", id)
                    .setParameter("name", product.getName())
                    .setParameter("description", product.getDescription())
                    .setParameter("price", product.getPrice())
                    .executeUpdate();
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            String errorMessage = String.format("Fail to update a product with id=%d", product.getId());
            LOG.error(errorMessage, e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Failed to delete product by id " + id, e);
        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> productRecords;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            productRecords = entityManager.createQuery(READ_ALL)
                    .getResultList();

            entityManager.getTransaction().commit();
            return productRecords;
        } catch (Exception e) {
            LOG.error("Failed to get list of products", e);
            throw new RuntimeException(e);
        }
    }

    public List<Product> readByIds(Set<Integer> productIds) {
        List<Product> productRecords = new ArrayList<>();
        try {

            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            productRecords = entityManager.createQuery(READ_ALL_IN)
                    .setParameter("productIds", productIds)
                    .getResultList();

            entityManager.getTransaction().commit();
            return productRecords;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productRecords;
    }
}