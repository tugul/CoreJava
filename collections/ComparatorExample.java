package collections;

import java.util.*;

/**
 * java.util.Comparator:
 * - Class of comparing its objects doesn't need to implement it
 * - Comparing logic can be written in separate class which implements Comparator
 * - Abstract method: int compare(T o1, T o2)
 * - Lambda expression is often used to implement comparison logic
 *
 */
class sortCarByPrice implements Comparator<Car> {
    @Override public int compare(Car car, Car t1) {
        return car.price - t1.price;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Chevrolet", 80, 1980));
        cars.add(new Car("Porsche", 70, 1990));
        cars.add(new Car("Cadillac", 100, 2000));

        // Sorting logic in separate class implementing Comparator
        Collections.sort(cars, new sortCarByPrice());

        // sorting logic in implementation of anonymous class
        Comparator<Car> sortCarByYear = new Comparator<Car>() {
            @Override public int compare(Car car1, Car car2) {
                return car1.year - car2.year;
            }
        };
        Collections.sort(cars, sortCarByYear);

        // Sort by name using lambda
        Comparator<Car> sortCarByYearLambda = (c1, c2) -> c1.name.compareTo(c2.name);
        Collections.sort(cars, sortCarByYearLambda);

        // Even simpler version
        Collections.sort(cars, (c1, c2) -> c1.name.compareTo(c2.name));
    }
}