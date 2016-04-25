package collections;

import java.util.*;

/**
 * java.lang.Comparable:
 * - Class of comparing its objects must implement Comparable
 * - Abstract method: int compareTo(T o), requires implementing class to override
 * - TreeSet, TreeMap are sorted collections, so classes to use them must implement Comparable
 * - Classes to use other collections must implement Comparable to use Collections framework's ordering methods like sort ...
 *
 */

class Vehicle {
    String name = "Vehicle";
    int price;
    int year;
}

class Car extends Vehicle implements Comparable<Car> {
    Car() {}
    Car(String name, int price, int year) {
        this.name = name;
        this.price = price;
        this.year = year;
    }

    @Override public int compareTo(Car car) { return name.compareTo(car.name); }
    @Override public String toString() { return name; }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Chevrolet", 80, 1980));
        cars.add(new Car("Porsche", 70, 1990));
        cars.add(new Car("Cadillac", 100, 2000));

        // sorting logic implemented in Car class itself
        Collections.sort(cars);
        System.out.println(cars);   // [Cadillac, Chevrolet, Porsche]

        // Vehicle must implement Comparable to be sorted in collection
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle());
        Collections.sort(vehicleList);    // DOES NOT COMPILE, vehicle is not Comparable

        // TreeMap and TreeSet are sorted collection,
        // TreeMap requires its key object to be Comparable
        // TreeSet requires its contained objects to be Comparable as well
        TreeMap<Vehicle, String> vehicleMap = new TreeMap<>();
        vehicleMap.put(new Vehicle(), "Vehicle");   // ClassCastException, can't cast Vehicle to Comparable
        vehicleMap.put(new Car(), "Car");

        TreeSet<Vehicle> vehicleSet = new TreeSet<>();
        vehicleSet.add(new Vehicle());              // ClassCastException, can't cast Vehicle to Comparable
        vehicleSet.add(new Car());

        // To avoid it, Comparator implementation can be provided in constructor
        TreeSet<Vehicle> vehicleComparableSet = new TreeSet<>(new Comparator<Vehicle>() {
            @Override public int compare(Vehicle v1, Vehicle v2) {
                return v1.name.compareTo(v2.name);
            }
        });
        vehicleComparableSet.add(new Vehicle());
    }
}
