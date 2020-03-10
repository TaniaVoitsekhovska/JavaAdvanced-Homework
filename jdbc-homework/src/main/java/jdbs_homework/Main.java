package jdbs_homework;

import jdbs_homework.classes.Author;
import jdbs_homework.classes.Book;
import jdbs_homework.classes.FullLibrary;
import jdbs_homework.classes.Library;
import jdbs_homework.classesDao.AuthorDao;
import jdbs_homework.classesDao.BookDao;
import jdbs_homework.classesDao.LibraryDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

       // using BookDao class methods in table book
        BookDao bookDao=new BookDao();
        List<Book> bookList=bookDao.readAll();
        bookList.forEach(book -> System.out.println(book));
        bookDao.insert("WAKE UP!","Як перестати жити на автопілоті",9786176794311l,
                245.55,1);
        bookList=bookDao.readAll();
        System.out.println();
        bookList.forEach(book -> System.out.println(book));
        bookDao.updateByID(3,"Спадщина чотирьох господинь","Ця книжка — важливий спадок.",
                9786176795315l,125.25,3);
        bookList=bookDao.readAll();
        System.out.println();
        bookList.forEach(book -> System.out.println(book));

        // using AuthorDao class methods in table author
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.readAll();
        authorList.forEach(author -> System.out.println(author));
        authorDao.insert("Олег","Короткий","oleh@gmail.com","Україна, м.Львів, вул.Садова 121",
                LocalDate.parse("2018-11-11"));
        authorList=authorDao.readAll();
        System.out.println();
        authorList.forEach(author -> System.out.println(author));
        authorDao.updateBySurname("Довгий", "Короткий");
        authorList=authorDao.readAll();
        System.out.println();
        authorList.forEach(author -> System.out.println(author));

        // using LibraryDao class methods in table library
        LibraryDao libraryDao = new LibraryDao();
        List<Library> libraryList = libraryDao.readAll();
        libraryList.forEach(library -> System.out.println(library));
        libraryDao.insert(3,3);
        libraryDao.readAll();
        libraryList.forEach(library -> System.out.println(library));
        List<FullLibrary> fullLibraryList=libraryDao.readAllwithNames();
        System.out.println();
        fullLibraryList.forEach(fullLibrary -> System.out.println(fullLibrary));


    }
}
