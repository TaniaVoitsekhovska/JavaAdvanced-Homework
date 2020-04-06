package ua.lviv.home.daos;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;
import ua.lviv.home.EntityManagerUtils;
import ua.lviv.home.enteties.Bucket;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class BucketDao implements CRUD<Bucket> {

    private static final Logger LOG = Logger.getLogger(BucketDao.class);

    private static String READ_ALL = "select b from Bucket b";
    private static String READ_ALL_BY_USER_ID = "select b from Bucket b where b.userId in (:userId)";
    private static String READ_BY_ID = "select b from Bucket b where b.id =:id";

    public BucketDao() {
    }

    @Override
    public Bucket insert(Bucket bucket) {
        String message = String.format("Will create a bucket for userId=%d and productId=%d",
                bucket.getUserId(), bucket.getProductId());
        LOG.debug(message);

        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(bucket);
            entityManager.flush();
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            String errorMessage = String.format("Fail to create a bucket for userId=%d and productId=%d",
                    bucket.getUserId(), bucket.getProductId());
            LOG.error(errorMessage, e);
        }
        return bucket;
    }

    @Override
    public Bucket read(int id) {
        Bucket bucket = null;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            bucket = entityManager.createQuery(READ_BY_ID, Bucket.class)
                    .setParameter("id", id)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            return bucket;
        } catch (Exception e) {
            String errorMessage = String.format("Fail to get a bucket with id=%d", id);
            LOG.error(errorMessage, e);
        }
        return bucket;
    }

    @Override
    public void update(Bucket t, int id) {
        throw new NotImplementedException("there is no update method for bucket");
    }

    @Override
    public void delete(int id) {
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            Bucket bucket = entityManager.find(Bucket.class, id);
            entityManager.remove(bucket);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Failed to delete bucket by id " + id, e);
        }
    }

    @Override
    public List<Bucket> readAll() {

        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            bucketRecords = entityManager.createQuery(READ_ALL)
                    .getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Failed to get list of buckets", e);
        }

        return bucketRecords;
    }

    public List<Bucket> readAllByUserId(int userId) {

        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            bucketRecords = entityManager
                    .createQuery(READ_ALL_BY_USER_ID)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bucketRecords;
    }

}
