package operator;

/**
 * Switch statement's decision variable:
 * - int, byte, short, char, String, Enum and Integer, Byte, Short, Character
 * - long, double, float, boolean and their wrapper classes are not allowed
 *
 * Case label:
 * - Allows only constant expression, such as any non-constant variables
 * - must be unique
 * - doesn't allow number and allow only Enum elements if decision variable is Enum
 */
public class SwitchStatement {
    public static void main(String[] args) {
        int _int = 5;
        final byte _byte = 10;
        switch (_int){
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 2:                 // DOES NOT COMPILE, duplicate label
            case _int:              // DOES NOT COMPILE, constant expression required
            case args.length:       // DOES NOT COMPILE, constant expression required
            case "a":               // DOES NOT COMPILE, incompatible type
            case _byte:
        }

        long _long = 5;
        switch (_long){     // DOES NOT COMPILE, long not allowed
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Other");
        }

        String a = "a";
        String b = "a";
        final String c = "a";
        switch (a){
            case "f":
            case b: // DOES NOT COMPILE, constant expression required
            case c:
        }
    }
}
