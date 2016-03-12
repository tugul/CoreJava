package operator;

/**
 * - Don't mix assignment operator with equality
 * - Assignment operator returns assigned value
 * - Equality operator requires same type of compared values
 */
public class DontMixAssignmentwithEquality {
    public static void main(String[] args) {
        // Assignment operator returns assigned value
        int _int = 10;
        boolean _bool=true;
        System.out.println(_int=30);        // prints 30
        System.out.println(_bool=false);    // prints false
        System.out.println(_bool==false);   // prints true

        boolean y = false;
        boolean x = (y = false);    // Assignment operator, x = false
        boolean z = (y == false);   // Equality operator, z = true;

        boolean b1 = false;
        boolean b2 = true;

        // != has higher priority than =, So it will be 'false = b2'
        if (b2 != b1 = b2)          // DOES NOT COMPILE,
            System.out.println("true");
        else
            System.out.println("false");

    }
}
