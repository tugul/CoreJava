package designpatterns;

/**
 * Singleton:
 * - creational pattern ensures creating only one instance of object
 * - the single instance is shared by all classes and threads within application
 * - improves performance by loading reusable data once without store/reload everytime it needs
 * - be aware of concurrency, developer should provide thread safety
 *
 * Common behaviour:
 * - uses private final static variable which is accessed by public static method
 * - has private constructors, so instantiation will occur only inside own class
 * - setter methods should be protected from multi-thread accesses (i.e. using modifier 'synchronized')
 *
 * - Creating singletons:
 * 1. Instantiation in static class member
 * 2. Instantiation in static initializer
 * pros: Once started up, accessing to resource is faster
 * cons: Slow startup and uses much memory throughout application life-time
 *
 * 3. Lazy instantiation (in getter method)
 * pros: quick startup and use less memory
 * cons: slow when first time resource is needed
 *
 */

// 1. Instantiation in static class member
class Singleton1 {
    private int value;
    final static Singleton1 instance = new Singleton1();
    private Singleton1() {}
    public static Singleton1 getInstance() { return instance; }
    public synchronized void addValue(int value) { this.value += value; }
}

// 2. Instantiation in static initializer
class Singleton2 {
    private int value;
    final static Singleton2 instance;
    static { instance = new Singleton2(); }
    private Singleton2() {}
    public static Singleton2 getInstance() { return instance; }
    public synchronized void addValue(int value) { this.value += value; }
}

// 3. Lazy instantiation (in getter method)
class Singleton3 {
    private int value;
    static Singleton3 instance;
    private Singleton3() {}
    public synchronized void addValue(int value) { this.value += value; }

    // Not thread-safe
    public static Singleton3 getInstance1() {
        if (instance == null)
            instance = new Singleton3();
        return instance;
    }

    // Thread-safe, but costly because every calls will be queued
    public synchronized static Singleton3 getInstance2() {
        if (instance == null)
            instance = new Singleton3();
        return instance;
    }

    // Double-check locking, faster as only first few calls will be queued
    public static Singleton3 getInstance3() {
        if (instance == null){
            synchronized (Singleton3.class){
                if (instance == null)
                    instance = new Singleton3();
            }
        }
        return instance;
    }
}
public class Singleton {
}
