package designpatterns;

/**
 * Factory pattern:
 * - creational pattern to create instance of set of related class based on given parameters
 * - supports polymorphism
 * - provides loose coupling between caller and target related classes
 *
 * Common behaviour:
 * - use a separate class for target related classed
 * - usually named with suffix Factory
 * - uses static method to return instance
 * - factory class and target classes usually packaged in same package
 * - usually instantiation is provided only through factory class, not directly from target class
 */

abstract class Car {
    int price;

    public Car(int price) {
        this.price = price;
    }

    public int getPrice() { return price; }

    public abstract void sold();
}

class Benz extends Car {
    Benz(int price) { super(price); }

    @Override public void sold() {
        System.out.println("Benz sold: " + getPrice());
    }
}

class Toyota extends Car {
    Toyota(int price) { super(price); }

    @Override public void sold() {
        System.out.println("Toyota sold: " + getPrice());
    }
}

class Ford extends Car {
    Ford(int price) { super(price); }

    @Override public void sold() {
        System.out.println("Ford sold: " + getPrice());
    }
}

class CarFactory {
    public static Car getCar(String name){
        switch (name){
            case "Benz 300" : return new Benz(100);
            case "Ford Cruiser" : return new Ford(120);
            case "Lexus" : return new Toyota(150);
            default:
                throw new UnsupportedOperationException("Unsupported car: " + name);
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        final Car car = CarFactory.getCar("Ford Cruiser");
        car.sold();
    }
}
