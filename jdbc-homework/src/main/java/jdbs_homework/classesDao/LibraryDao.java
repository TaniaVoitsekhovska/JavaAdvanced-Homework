package jdbs_homework.classesDao;

import jdbs_homework.classes.FullLibrary;
import jdbs_homework.classes.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDao {
    public Library insert(int book_id, int author_id) {
        String sqlQuery = "insert into library(book_id,author_id) values (?,?)";

        Library library = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        connection = LibraryDB_Dao.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, book_id);
            statement.setInt(2, author_id);
            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating library failed, no rows affected!");
            } else {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                return new Library(resultSet.getInt(1), book_id, author_id);
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
    public List<Library> readAll() throws SQLException {
        String sqlQuery = "select * from library";

        List<Library> libraryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = LibraryDB_Dao.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                libraryList.add(new Library(resultSet.getInt("id"), resultSet.getInt("book_id"),
                        resultSet.getInt("author_id")
                ));
            }
        } catch (SQLException e) {
            throw new SQLException("Getting list of library failed!", e);
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

        return libraryList;
    }

    public List<FullLibrary> readAllwithNames() throws SQLException {
        String sqlQuery = "select library.id, book.book_title, author.name, author.surname,author.email, book.book_price" +
                " from library join book on book_id=book.id join author on author_id=author.id order by library.id";

        List<FullLibrary> libraryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = LibraryDB_Dao.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                libraryList.add(new FullLibrary(resultSet.getInt("id"),
                        resultSet.getString("book_title"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getDouble("book_price")
                ));
            }
        } catch (SQLException e) {
            throw new SQLException("Getting list of library failed!", e);
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

        return libraryList;
    }
}
