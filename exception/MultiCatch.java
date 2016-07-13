package exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.sql.SQLException;

/**
 * - MultiCatch block
 * introduced in Java 7
 * multiple exceptions can be caught in same catch block
 * those must be unrelated class
 *
 * Note:
 * It is illegal to reassign the exception inside multi-catch
 * while it is allowed in single exception catch block
 *
 *
 */
public class MultiCatch {
    private static void throwsExceptions() throws Exception { }

    public static void main(String[] args) {
        try {
            throwsExceptions();
        }
        catch(IllegalArgumentException | SQLException e){
            e.printStackTrace();
        }
        catch(FileNotFoundException | IOException e){       // DOES NOT COMPILE, must be unrelated exceptions
            // FileNotFoundException extends IOException
        }
        catch (ArithmeticException | ClassNotFoundException e){
            e = new RuntimeException();                     // DOES NOT COMPILE, reassign not allowed in multi-catch
        }
        catch (Exception e)
        {
            e = new RuntimeException("Re-assigned exception");   // reassigning exception is allowed in single catch
        }
    }
}
