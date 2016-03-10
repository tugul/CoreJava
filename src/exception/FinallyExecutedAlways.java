package exception;

/**
 * Finally block is always executed no matter how flow goes on and out.
 * OBS: Only System.exit() prevents finally block execution
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
