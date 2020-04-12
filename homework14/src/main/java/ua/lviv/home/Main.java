package ua.lviv.home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();



        Cart cart = new Cart(22.22,"fff");

        Item item1 = new Item(55.69);
        Item item2 = new Item(99.99);
        Item item3 = new Item(299.50);
        Item item4 = new Item(10.00);
        cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));

        session.persist(cart);

        transaction.commit();

    }
}
