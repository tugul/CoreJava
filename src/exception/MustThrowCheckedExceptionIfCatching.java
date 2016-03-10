package exception;

import java.io.IOException;

/**
 * Checked exception must be thrown in try block if catch block is explicitly catching it.
 * For unchecked/runtime exception, it does not matter if to throw or to declare
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
}
