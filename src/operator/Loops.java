package operator;

/**
 * Curly braces are not mandatory for single line body of loop, even for do while statement
 */
public class Loops {
    public static void main(String[] args) {
        do
            System.out.println("One time");
        while(false);

        do System.out.println("One time"); while(false);

        boolean lock = true;
        while(lock)
            System.out.println(lock=false);
    }
}
