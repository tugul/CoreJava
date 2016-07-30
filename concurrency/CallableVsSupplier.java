package concurrency;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Supplier and Callable functional interfaces are same
 * in that they both take no argument and return generic type.
 *
 * But they diverge in that Callable throws checked Exception
 * while Supplier's get() method does not. In short:
 * 	Callable: V call() throws Exception
 * 	Supplier: V get()
* 	Runnable: void run()
 *
 */
public class CallableVsSupplier {
    public static void useCallable(Callable<Integer> arg) {}
    public static void useSupplier(Supplier<Integer> arg) {}

    public static void use(Supplier<Integer> arg) {}
    public static void use(Callable<Integer> arg) {}

    public static void main(String[] args) {
        useCallable( () -> {throw new IOException();});  // COMPILES
        useSupplier( () -> {throw new IOException();});  // DOES NOT COMPILE, as Supplier doesn't throw exception

        use( () -> {throw new IOException();});          // DOES NOT COMPILE, ambiguous call to overloaded methods
        use( (Callable<Integer>)() -> {throw new IOException();});       // Ambiguity is resolved by explicit cast
    }
}
