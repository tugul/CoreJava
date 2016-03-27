package generics;

/**
 * Generic class provides type safety and re-usability
 *
 * T - placeholder, any letter or letters declared in angle bracket are generic types
 * The letters representing types must match literally when used! (regardless of inherited types)
 *
 */

class GeneralWithTwo <T, e> {
    T t;
    e e;
}

class AnotherGeneral <A, b, C> {
    A a;
    b b;
    C c;
}

public class GenericClass<T> {
    private T tag;

    public GenericClass(T tag){
        this.tag = tag;
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
