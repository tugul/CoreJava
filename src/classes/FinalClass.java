package classes;

/**
 * Final class
 * - can't be extended, complete as it is
 * - automatically its all methods will be assumed final
 *
 * Final method
 * - can't be overridden
 *
 * Final field
 * - can't be reassigned
 *
 * Common final classes:
 * String, StringBuilder
 */

final class LastEmperor {
    String name;
    final int age = 199;
    void setName(String name){this.name = name;}
    static void delete() {}
}
public class FinalClass {
    public static void main(String[] args) {
        LastEmperor emperor = new LastEmperor();
        emperor.setName("Karl");
        System.out.println(emperor.age);
        System.out.println(LastEmperor.age);    // DOES NOT COMPILE, final fields are not static
    }
}
