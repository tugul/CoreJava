package classes;

/**
 * Static members can be accessed not only through class name,
 * but also through instance of the class.
 * Even when reference of the instance points to NULL
 *
 * But instance members can't be accessed if reference points to NULL
 */

class A {
    static int staticField;
    int instanceField;

    public static void main(String[] args) {
        System.out.println(staticField);
    }
}

public class StaticMember {
    public static void main(String[] args) {
        A.main(new String[0]);                  // 0

        A a = new A();
        System.out.println(a.staticField);      // 0
        a.instanceField = 100;
        a = null;
        System.out.println(a.staticField);      // 0
        System.out.println(a.instanceField);    // NullPointerException

        A b;
        System.out.println(b.staticField);      // 0
        System.out.println(A.staticField);      // 0
    }
}
