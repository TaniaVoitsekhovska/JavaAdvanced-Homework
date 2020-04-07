package ua.lviv.home;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashSet;

public class Application
{
    public static void main( String[] args ) {


        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();

        Post first = new Post("review");

        Comment comment1 = new Comment("John");
        comment1.setPost(first);
        Comment comment2 = new Comment("Mary");
        comment2.setPost(first);
        Comment comment3 = new Comment("Ivan");
        comment3.setPost(first);

        first.setComments(new HashSet<>(Arrays.asList(comment1, comment2, comment3)));

        session.save(first);

        session.flush();
        transaction.commit();

        System.out.println();
        printTransactionData(first.getId(),session);

        session.close();
    }
    
    private static void printTransactionData(int id,Session session){

        session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Post post=session.get(Post.class,id);
        transaction.commit();

        System.out.println(post + " contains " + post.getComments());
    }
}
