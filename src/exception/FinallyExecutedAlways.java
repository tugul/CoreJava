package exception;

/**
 * Finally block is always executed no matter how flow goes on and out.
 *
 * - Only followings can prevent execution of 'finally' block
 * System.exit() in try block
 * Infinite loop in try block
 * JVM crash
 *
 */
public class FinallyExecutedAlways {
    public static void main(String[] args) {
        try {
            System.out.println("in try block");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("in finally block");
        }

    }
}
