package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * - Serialization
 * It is process converting object in memory into a stored data format. Reverse process is called Deserialization.
 * Objects to be serialized must be type of Serializable, i.o. must implement interface Serializable
 *
 * Any instance variable in Serializable class must be also Serializable in order for composite object to be serialized
 * Attempt to serialize object which is not Serializable will compile, but compiler will throw NotSerializableException
 * 'transient' instance variables or primitives ->  not serialized, set to default value of their types when de-serialized
 * non-transient primitives -> serialized, means last value is restored back
 * Static variables -> not serialized, last set value reflects to all objects when de-serialized
 * final long serialVersionUID -> optional/special static member used by JVM during de-serialization
 *
 * ObjectInputStream    de-serialize stream into object
 * ObjectOutputStream   serialize object into stream
 *
 * Note:
 * During de-serialization, constructor or any initializer of the serialized class won't be run
 * Just reference to non-serializable class won't trigger NotSerializableException unless not holding real object
 *
 * Marking instance reference of non-serializable class 'transient' won't lead to throw NotSerializableException
 * but data stored in the object will be lost during serialization.
 *
 */

class Wheel{
    // It is not Serializable and its reference is used in Car Serializable
    // As long as the reference is not referring to object in memory, it won't lead Car class fail to compile
}

class Car implements Serializable {
    private static final long serialVersionUID = 250L;
    private static String model;           // String is Serializable
    private transient int price;    // transient -> value won't be restored i.e default value will overwrite
    private boolean isNew;          // non-transient - value will be restored
    private Wheel wheel;            // reference to non-serializable class
    private List<Integer> gears;    // non-transient - value will be restored

    { price += 50; }

    public Car() {
        model = "Sedan";
        price = 100;
        isNew = true;
        gears = Arrays.asList(3,4);
        //wheel = new Wheel();      // will throw NotSerializableException, make it transient to avoid the exception
    }

    public Car(String model, int price, boolean isNew, Wheel wheel) {
        this.model = model;
        this.price = price;
        this.isNew = isNew;
        gears = Arrays.asList(1,2,3);
        //this.wheel = wheel;       // will throw NotSerializableException
    }

    public String toString(){
        return "Car=[model: " + model + ", price: "+ price+", new: " + isNew + ", gears: " + gears + " ] ";
    }
}

public class Serialization {

    // Serializing list of Car objects
    static void writeCarsToFile(List<Car> cars, String destination) throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(new File(destination))))){
            for(Car car : cars)
                out.writeObject(car);

            // Below statement needs to handle IOException from writeObject(), otherwise won't compile
            //cars.stream().forEach(x -> out.writeObject(x));
        }
    }

    // De-serializing list of Car objects
    static List<Car> readCarsFromFile(String source) throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(source))))){
            while(true) {
                Object object = in.readObject();  // throws ClassNotFoundException if class Car is not found at runtime
                if (object instanceof Car)
                    cars.add((Car)object);
            }
        }
        catch (EOFException e){ /* end of file */ }
        return cars;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car("Hatchback", 130, false, new Wheel()));

        System.out.println("Before serialization");
        cars.forEach(System.out::println);
        writeCarsToFile(cars, "Cars.out");  // Serializing

        System.out.println("After de-serialization");
        readCarsFromFile("Cars.out").forEach(System.out::println);
    }
}

/*
Before serialization
Car=[model: Hatchback, price: 100, new: true, gears: [3, 4] ]
Car=[model: Hatchback, price: 130, new: false, gears: [1, 2, 3] ]
After de-serialization
Car=[model: Hatchback, price: 0, new: true, gears: [3, 4] ]
Car=[model: Hatchback, price: 0, new: false, gears: [1, 2, 3] ]
*/
