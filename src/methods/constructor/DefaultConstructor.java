package methods.constructor;

/**
 * Default constructor has no parameter list and no body
 * As a constructor, it must not have return type, of course
 */
public class DefaultConstructor {
    // true default constructor
    DefaultConstructor(){}

    // Java is case-sensitive, exception: return type required
    defaultConstructor(){} // DOES NOT COMPILE

    // Valid constructor, but not default one
    DefaultConstructor(int a){}

    // Not constructor as having return type, just a method
    void DefaultConstructor(){}

}
