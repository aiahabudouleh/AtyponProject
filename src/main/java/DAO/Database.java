/**
 * Database, create connection with dbProject.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    /**
     * Data base information.
     *
     * */
    private static String dbUrl = "jdbc:mysql://localhost:3306/dbProject";
    private static String dbUsername = "root";
    private static String dbPassword = "password";
    private static java.sql.Connection connection = null;


    public static Connection connect() {
        setClassName();
        setConnection();
        return connection;
    }

    private static void setClassName() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("error: Journals DAO, class not found exception");
            System.out.println(e.getMessage());
        }
    }

    private static void setConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println("error: Journals DAO, connection with database error");
            System.out.println(e.getMessage());
        }
    }


}

