package varargs;

/**
 * args contains only user given arguments
 * not class name or any java commands
 */

public class StringArgsInMain {
    public static void main(String... args) {
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(0 + " - " + args[i]);
        }
    }
}
