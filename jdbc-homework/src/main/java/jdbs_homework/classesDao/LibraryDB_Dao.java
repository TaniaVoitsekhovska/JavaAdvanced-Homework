package jdbs_homework.classesDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryDB_Dao {

    private static LibraryDB_Dao instance;
    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/libraries";
    private String user = "root";
    private String password = "root";

    private LibraryDB_Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver class can't be found!" + e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Database connection creation failed!" + e);
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static LibraryDB_Dao getInstance() {
        if (instance == null) {
            instance = new LibraryDB_Dao();
        } else
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new LibraryDB_Dao();
                }
            } catch (SQLException e) {
                System.out.println("Database access error!" + e);
            }
        return instance;
    }
}
