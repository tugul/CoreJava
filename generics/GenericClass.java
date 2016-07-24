package generics;

/**
 * Generic class provides type safety and re-usability
 *
 * T - placeholder, any letter or letters declared in angle bracket are generic types
 * The letters representing types must match literally when used! (regardless of inherited types)
 *
 * Limitations on generic types:
 * - can't call constructor of generic type: new T()
 * - can't create array of static type: new T[]
 * - can't call instanceof: obj instanceof T
 * - can't use primitive as generic type, instead use their wrapper classes
 * - can't create static variable with generic type
 * - can't create static method with generic type defined in generic class definition
 */

class GeneralWithTwo <T, e> {
    T t;
    e e;
}

class AnotherGeneral <A, b,C, d extends C> {
    A[] a;
    b b;
    C c;
}

public class GenericClass<T> {
    private T tag;
    public static T t;		// DOES NOT COMPILE, generic type can't be used in static context
    
    public static void method1(T t) {}	// DOES NOT COMPILE
    public static void method3() {
    	T t;							// DOES NOT COMPILE
    }
    public void methodNonStatic(T t) {}	// COMPILES

    public GenericClass(T tag){
        this.tag = tag;

        boolean isIt = tag instanceof T;    // DOES NOT COMPILE
        T[] aa = new T[10];                 // DOES NOT COMPILE
        T t = new T();                      // DOES NOT COMPILE
    }

    public T getTag(){
        return tag;
    }

    public static void main(String[] args) {
        GenericClass<Integer> gcI = new GenericClass<>(100);
        System.out.println(gcI.getTag());   // 100

        GenericClass<String> gcS = new GenericClass<>("General");
        System.out.println(gcS.getTag());   // General

        Integer i = gcS.getTag();   // DOES NOT COMPILE, type safety works!
    }
}
