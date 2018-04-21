package varargs;

/**
 * varargs to main method contains only user given arguments
 * neither class name nor any options
 */

public class StringArgsInMain {
    public static void main(String... args) {
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + " - " + args[i]);
        }
    }
}
