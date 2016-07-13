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
 * Those 2 helper classes have factory method to create connection.
 *
 * - Closing connection
 * Resourced opened in try/with statement are closed automatically
 * Closing connection closes statements and resultsets as well
 * Closing statement closes its resultsets as well
 * ResultSet is automatically closed when new SQL is run on the same statement
 *
 */
public class ConnectionToDatabase {
    public static void main(String[] args) throws ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql:devalto";

        // Required to load class for JDBC 3.0 or prior versions
        Class.forName("org.postgresql.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select name from table")) {

            while (rs.next())
                System.out.println(rs.getString(1));
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }
}
