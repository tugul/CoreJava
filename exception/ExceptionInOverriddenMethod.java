package exception;

import java.io.IOException;

/**
 * - Overriding method in child class is not required to throw a exception even when parent method throws some exception
 * - Overriding method can throw same as in parent or any new type of unchecked exception
 * - Overriding method can throw same or sub type of exception thrown in parent method, but not new or broader type of checked exception!
 */

class Parent {
    String name;
    void getName() {}
    void getAge() throws IllegalArgumentException {}
    void readFile() throws IOException { }
    void findClass() throws ClassNotFoundException { }
}

public class ExceptionInOverriddenMethod extends Parent {
    void getName() throws RuntimeException { }   // new unchecked exception
    void getAge() throws RuntimeException { }    // broader unchecked exception
    void readFile() throws RuntimeException { }  // silenced checked exception, new unchecked exception
    void findClass () throws Exception { }       // DOES NOT COMPILE, broader checked exception not allowed
}
