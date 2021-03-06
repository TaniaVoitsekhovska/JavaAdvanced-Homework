package ua.lviv.home.services;

import ua.lviv.home.daos.UserDao;
import ua.lviv.home.enteties.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private UserDao userDao;

    private static UserService userService;

    private UserService() {
        this.userDao = new UserDao();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void insert(String email, String firstName, String lastName, String password) {
        userDao.insert(
                User.builder()
                        .setEmail(email)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setPassword(password)
                        .build());
    }

    public User read(int id) {
        return userDao.read(id);
    }

    public void update(User t, int id) {
        userDao.update(t, id);
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }

    public List<User> readAll() {
        return userDao.readAll();
    }

    public Optional<User> getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    public Optional<User> getByEmailAndPassword(String email, String password) {
        return userDao.getByEmail(email).filter(user -> user.getPassword().equals(password));
    }
}
