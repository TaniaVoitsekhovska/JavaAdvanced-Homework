package ua.lviv.home.daos;

import org.apache.log4j.Logger;
import ua.lviv.home.EntityManagerUtils;
import ua.lviv.home.enteties.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserDao implements CRUD<User> {

    private static final Logger LOG = Logger.getLogger(UserDao.class);


    public static final String SELECT_ALL = "SELECT u FROM User u";
    public static final String UPDATE = "UPDATE User u SET u.email = :email, u.firstName = :firstName, " +
            "u.lastName = :lastName, u.role = :role, u.password = :password where u.id = :id";
    public static final String SELECT_BY_ID = "SELECT u FROM User u where u.id = :id";
    public static final String SELECT_BY_EMAIL = "SELECT u FROM User u where u.email = :email";

    public UserDao() {
    }

    @Override
    public User insert(User user) {
        String message = String.format("Will create a user for  userId=%d", user.getId());
        LOG.debug(message);
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            String errorMessage = String.format("Error while inserting a user for productId=%d", user.getId());
            LOG.error(errorMessage, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public User read(int id) {

        User user;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            user = entityManager.createQuery(SELECT_BY_ID,User.class)
                    .setParameter("id", id)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            String errorMessage = String.format("Error while getting user by id=%d", id);
            LOG.error(errorMessage, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> readAll() {
        List<User> users;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            users = entityManager.createQuery(SELECT_ALL)
                    .getResultList();

            entityManager.getTransaction().commit();
            return users;
        } catch (Exception e) {
            LOG.error("Error while getting all users", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class,id);
            entityManager.remove(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            String errorMessage = String.format("Error while deleting user by id=%d", id);
            LOG.error(errorMessage, e);
        }
    }

    @Override
    public void update(User user, int id) {
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery(UPDATE)
                    .setParameter("id",id)
                    .setParameter("email",user.getEmail())
                    .setParameter("firstName",user.getFirstName())
                    .setParameter("lastName",user.getLastName())
                    .setParameter("role",user.getRole())
                    .setParameter("password",user.getPassword())
                    .executeUpdate();
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            String errorMessage = String.format("Error while updating user id=%d", user.getId());
            LOG.error(errorMessage, e);
        }
    }


    public Optional<User> getByEmail(String email) {

        User user;
        try {
            EntityManager entityManager = EntityManagerUtils.getEntityManager();
            entityManager.getTransaction().begin();
            user = (User) entityManager.createQuery(SELECT_BY_EMAIL)
                    .setParameter("email", email)
                    .getSingleResult();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            String errorMessage = String.format("Error while getting user by email=%s", email);
            LOG.error(errorMessage, e);
            user = null;
        }
        return Optional.ofNullable(user);

    }
}
