package technical.test.model.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection
 *
 * @author Luis Gómez
 */
public class DbConnect {

    private static DbConnect instance;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BD_URL = "jdbc:mysql://" + "127.0.0.1/BackEndExam3";
    private final String USER = "testuser";
    private final String PASS = "testpsw";

    /**
     * Singleton constructor.
     */
    private DbConnect() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.append("Instalation error. Contact to the admin");
            System.exit(-1);
        }
    }

    /**
     * Singelton Instance for conection to the data base.
     *
     * @return unique instance.
     */
    public static DbConnect getInstance() {
        if (instance == null) {
            instance = new DbConnect();
        }
        return instance;
    }

    /**
     * Conection for the data base.
     *
     * @return connection or null in case of error.
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BD_URL, USER, PASS);
        } catch (SQLException e) {           
            conn = null;
        }
        return conn;
    }

}
