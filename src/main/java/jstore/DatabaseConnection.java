/**
 * <h1>DatabaseConnection.java</h1>
 * <p>
 * PostgreSQL Database Connection Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The type Database connection.
 */
public class DatabaseConnection {
    /**
     * Connection connection.
     *
     * @return the connection
     */
    protected static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jstore",
                            "postgres", "4ltius");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}