package ua.lviv.home;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashSet;

public class Main
{
    public static void main( String[] args ) {


        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();

        Post first = new Post("events");

        Comment comment1 = new Comment("lunch");
        comment1.setPost(first);
        Comment comment2 = new Comment("dinner");
        comment2.setPost(first);
        Comment comment3 = new Comment("birthday party");
        comment3.setPost(first);

        first.setComments(new HashSet<>(Arrays.asList(comment1, comment2, comment3)));

        session.save(first);

        session.flush();
        transaction.commit();

        session.close();
    }
}
