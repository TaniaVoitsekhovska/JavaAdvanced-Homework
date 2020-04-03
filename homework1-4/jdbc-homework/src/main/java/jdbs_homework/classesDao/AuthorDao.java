package jdbs_homework.classesDao;

import jdbs_homework.classes.Author;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    public Author insert(String name, String surname, String email, String adress, LocalDate birthday) {
        String sqlQuery = "insert into author(name,surname,email,adress,birthday) values (?,?,?,?,?)";

        AuthorDao authorDao = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        connection = jdbs_homework.classesDao.LibraryDB_Dao.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, adress);
            statement.setDate(5, Date.valueOf(birthday));
            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating author failed, no rows affected!");
            } else {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                return new Author(resultSet.getInt(1), name, surname, email, adress, birthday);
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

    public List<Author> readAll() throws SQLException {
        String sqlQuery = "select * from author";

        List<Author> authorList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = LibraryDB_Dao.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                authorList.add(new Author(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getString("email"),
                        resultSet.getString("adress"), resultSet.getDate("birthday").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new SQLException("Getting list of authors failed!", e);
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

        return authorList;
    }

    public boolean updateBySurname( String surnameToChange, String surname)
            throws SQLException {
        String sqlQuery = "update author set surname = ? where surname = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;

        try {
            connection = jdbs_homework.classesDao.LibraryDB_Dao.getInstance().getConnection();

            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, surnameToChange);
            statement.setString(2, surname);
            int rows = statement.executeUpdate();
            System.out.printf("%d row(s) updated!\n", rows);

            if (rows == 0) {
                throw new SQLException("Updating author failed, no rows affected!");
            } else {
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Updating author failed!", e);
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
            System.err.println("Updating author failed, no rows affected!");
        } else {
            System.out.println("Author with surname " + surnameToChange + " is updated in database!");
        }
        return result;
    }
}
