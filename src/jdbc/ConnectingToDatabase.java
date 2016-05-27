package jdbc;

import java.sql.*;

/**
 * java.sql.Driver
 *
 * - Connection URL
 * To access db, we need to build connection URL to connect to the database
 * Composed of 3 parts separated by colon - jdbc:<database_driver_name>:<database detail,host, port etc.>
 *
 * - DriverManager, DataSource
 * Those 2 helper classes are used to create connection
 *
 */
public class ConnectingToDatabase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql:devalto";

        // Required to load class for JDBC 3.0 or prior versions
        Class.forName("org.postgresql.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select name from table")) {

            while (rs.next())
                System.out.println(rs.getString(1));
        }
    }
}
