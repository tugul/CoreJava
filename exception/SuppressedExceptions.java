package exception;

/**
 * - Suppressed exception
 * Only one exception can be thrown by method per its execution. But when using try-with-resource,
 * it is possible for multiple exceptions to be thrown. Because attempt to close a resource in
 * try-with-resource can throw an exception besides one that might be explicitly thrown from body of try block.
 * In this case, exceptions from implicit finally block provided by try-with-resource are suppressed and primary
 * exception will be the one thrown from try block.
 *
 */
class BadClass implements AutoCloseable {
    String label;

    public BadClass(String label) {
        this.label = label;
    }

    @Override
    public void close() throws RuntimeException {
        throw new RuntimeException("Can't close " + label);
    }
}

public class SuppressedExceptions {
    public static void main(String[] args) {
        // Both of implicit finally and try block throw exceptions
        // Then, ones from implicit finally block are suppressed
        try(BadClass one = new BadClass("ONE");
            BadClass two = new BadClass("TWO")){
            throw new RuntimeException("thrown from try");
        }
        catch (RuntimeException e){
            System.out.println("Primary exception: " + e.getMessage());
            for (Throwable exception : e.getSuppressed())
                System.out.println("Suppressed exception: " + exception.getMessage());
        }
/* Output:
        Primary exception: thrown from try
        Suppressed exception: Can't close TWO
        Suppressed exception: Can't close ONE
*/

        // Try block doesn't throw any exception. First thrown one from implicit finally block
        // becomes primary and last ones will be suppressed. In below case two is closed first
        // according to reverse ordering and one will be closed last
        try(BadClass one = new BadClass("ONE");
            BadClass two = new BadClass("TWO")){

        }
        catch (RuntimeException e){
            System.out.println("Primary exception: " + e.getMessage());
            for (Throwable exception : e.getSuppressed())
                System.out.println("Suppressed exception: " + exception.getMessage());
        }
/* Output:
        Primary exception: Can't close TWO
        Suppressed exception: Can't close ONE
*/
    }
}
