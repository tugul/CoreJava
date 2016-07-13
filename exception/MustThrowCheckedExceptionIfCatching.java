package exception;

import java.io.IOException;

/**
 * Checked exception must be thrown inside try block if there is explicit catch block for that checked exception.
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
    }

    static void method() { }

    // One solution is to throw IOException
    // static void method() throws IOException { }
}
