package exception;

import java.io.IOException;

/**
 * Checked exception must be thrown inside try block if there is explicit catch block for that checked exception.
 * It is not case for Exception class and it can be in explicit catch block even when no exception is thrown in try block
 * Solution is either to remove unreachable catch block or throw that checked exception inside try block
 *
 * For unchecked/runtime exception, it does not matter whether to throw or declare
 */
public class MustThrowCheckedExceptionIfCatching {
    public static void main(String[] args) {
        try {
            method();
        }
        catch (RuntimeException e){
            System.out.println("unchecked exception caught");
        }
        catch (IOException e){ // DOES NOT COMPILE
            System.out.println("checked exception caught");
        }
        catch(Exception e){ } // Exception class can be here, it is not case for it
    }

    static void method() { }

    // One solution is to throw IOException
    // static void method() throws IOException { }
}
