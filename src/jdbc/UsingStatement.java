package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * - Statement
 * used for executing SQL statement and returns its results
 * its reference is created from connection
 * it can have only one ResultSet open at one time.
 *
 * - PreparedStatement
 * superior to Statement, actively used in practice
 * on performance: it uses cache, useful when running same query many times
 * security: use specific method to build SQL statement, not just simple string concatenation
 * readability: in case of many parameters in SQL, it looks unreadable to use simple string concatenation
 *
 */
public class UsingStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@home:1521:orcl";
        try (Connection conn = DriverManager.getConnection(url, "user", "pass"))
        {
            Statement statement = conn.createStatement();

            // executeQuery(String) - executes SELECT query only
            String sqlSelect = "select name, age from people";
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            System.out.println("The number of people: " + resultSet.getRow());

            // executeUpdate(String) - executes INSERT, DELETE, UPDATE queries
            String sqlToChange = "update people set name='Bold' where name='bold'";
            int resultCount = statement.executeUpdate(sqlToChange);

            // execute(String) - execute any type of SQL
            boolean isResultSet = statement.execute(sqlSelect);
            if (isResultSet) {
                ResultSet rs = statement.getResultSet();
                System.out.println("It is select query");
            }
            else {
                int result = statement.getUpdateCount();
                System.out.println("It is update query");
            }

            // Note: Mixing SQL type with its corresponding method throws SQLException
        }
    }
}
