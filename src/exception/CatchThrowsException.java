package exception;

/**
 * In catch block, exception can be thrown.
 * It must be handled or declared if it is "checked" exception
 * For "unchecked"/runtime exception, it is not mandatory to declare or handle
 */
class newException extends Exception {}

public class CatchThrowsException {
    public static void main(String[] args) {
        CatchThrowsException cte = new CatchThrowsException();

        try {
            cte.methodOne();
        }
        catch (newException e){
            cte.methodOne(); // DOES NOT COMPILE, unhandled CHECKED exception
        }
        catch (RuntimeException e){
            throw new RuntimeException("catch throws Runtime exception");
            System.out.println("Unreachable");  // DOES NOT COMPILE as this line is unreachable
                                                // because exception is thrown explicitly in previous line
        }
        catch (Exception e){
            cte.methodTwo();            // This method throws runtime exception
            System.out.println("DS");   // COMPILES. Unreachable line, but previous line doesn't explicitly throw
        }
        finally {
            cte.methodTwo();
        }
    }

    // checked exception is thrown
    public void methodOne() throws newException {
        throw new newException();
    }

    // declares and throws unchecked exception
    public void methodTwo() throws RuntimeException {
        throw new ArrayIndexOutOfBoundsException();
    }
}
