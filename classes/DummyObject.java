package classes;

/**
 * Beware of dummy object.
 * In below case, dummy instantiation won't change object init's field's value
 */
public class DummyObject {
    int value;

    public DummyObject() {
        this(100);
        new DummyObject(35);       // Create totally different unreferenced dummy object
    }

    public DummyObject(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        DummyObject init = new DummyObject();
        System.out.println(init.value);     // 100
    }
}
