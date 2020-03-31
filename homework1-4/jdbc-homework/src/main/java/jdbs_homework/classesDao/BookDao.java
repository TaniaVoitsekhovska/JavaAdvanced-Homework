package jdbs_homework.classesDao;

import jdbs_homework.classes.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public Book insert(String book_title, String description, long isbn, double book_price, int category_id) {
        String sqlQuery = "insert into book(book_title,description,isbn,book_price," +
                "category_id) values (?,?,?,?,?)";

        BookDao bookDao = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        connection = LibraryDB_Dao.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book_title);
            statement.setString(2, description);
            statement.setLong(3, isbn);
            statement.setDouble(4, book_price);
            statement.setInt(5, category_id);

            System.out.println(statement.toString());
            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating book failed, no rows affected!");
            } else {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                return new Book(resultSet.getInt(1), book_title, description, isbn, book_price, category_id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Result set can't be closed!" + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }
    }
    public List<Book> readAll() throws SQLException {
        String sqlQuery = "select * from book";

        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = jdbs_homework.classesDao.LibraryDB_Dao.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                bookList.add(new Book(resultSet.getInt("id"), resultSet.getString("book_title"),
                        resultSet.getString("description"), resultSet.getLong("isbn"),
                        resultSet.getDouble("book_price"),resultSet.getInt("category_id")
                ));
            }
        } catch (SQLException e) {
            throw new SQLException("Getting list of books failed!", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Result set can't be closed!" + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        return bookList;
    }

    public boolean updateByID(int id, String book_title, String description, long isbn,
                              double book_price, int category_id)
            throws SQLException {
        String sqlQuery = "update book set book_title = ?, description = ?,isbn = ?, book_price = ?, " +
                "category_id=? where id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;

        try {
            connection = jdbs_homework.classesDao.LibraryDB_Dao.getInstance().getConnection();

            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, book_title);
            statement.setString(2, description);
            statement.setLong(3, isbn);
            statement.setDouble(4, book_price);
            statement.setInt(5, category_id);
            statement.setInt(6, id);
            int rows = statement.executeUpdate();
            System.out.printf("%d row(s) updated!\n", rows);

            if (rows == 0) {
                throw new SQLException("Updating book failed, no rows affected!");
            } else {
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Updating book failed!", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        if (result == false) {
            System.err.println("Updating book failed, no rows affected!");
        } else {
            System.out.println("Book with ID#" + id + " is updated in database!");
        }
        return result;
    }
}
