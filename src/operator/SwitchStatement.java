package operator;

/**
 * Switch statement's decision variable:
 * int, byte, short, char, String, Enum and Integer, Byte, Short, Charactar
 *
 * long, double, float, boolean and their wrapper classes are not allowed
 */
public class SwitchStatement {
    public static void main(String[] args) {
        int _int = 5;
        switch (_int){
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Other");
        }

        long _long = 5;
        switch (_long){     // DOES NOT COMPILE
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Other");
        }
    }
}
