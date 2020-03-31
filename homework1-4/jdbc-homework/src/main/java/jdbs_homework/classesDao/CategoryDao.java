package jdbs_homework.classesDao;

import jdbs_homework.classes.Category;

import java.sql.*;

public class CategoryDao {
    public Category insert(String name) {
        String sqlQuery = "insert into category(`name`) values (?)";

        Category category = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        connection = LibraryDB_Dao.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating category failed, no rows affected!");
            } else {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                return new Category(resultSet.getInt(1), name);
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
}
