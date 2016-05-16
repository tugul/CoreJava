package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * - Serialization
 * It is process converting object in memory into a stored data format. Reverse process is called Deserialization.
 * Objects to be serialized must be type of Serializable, i.o. must implement interface Serializable
 *
 * Any instance variable in Serializable class must be also Serializable in order for composite object to be serialized
 * Attempt to serialize object which is not Serializable lead to throw NotSerializableException
 * transient instance variables ->  not serialized, set to default value of their types when de-serialized
 * Static variables -> not serialized, last set value reflects to to all objects when de-serialized
 * final long serialVersionUID -> optional/special static member used by JVM during de-serialization
 *
 * ObjectInputStream    de-serialize stream into object
 * ObjectOutputStream   serialize object into stream
 *
 * Note:
 * During de-serialization, constructor or any initializer of the serialized class won't be run
 * Just reference to non-serializable class won't trigger NotSerializableException unless not holding real object
 *
 */

class Wheel{
}

class Car implements Serializable {
    private static final long serialVersionUID = 250L;
    private static String model;    // String is Serializable
    private transient int price;
    private transient boolean isNew;
    private Wheel wheel;            // reference to non-serializable class

    { price += 50; }

    public Car() {
        model = "Sedan";
        price = 100;
        isNew = true;
        //wheel = new Wheel();      // will throw NotSerializableException
    }

    public Car(String model, int price, boolean isNew, Wheel wheel) {
        this.model = model;
        this.price = price;
        this.isNew = isNew;
        //this.wheel = wheel;       // will throw NotSerializableException
    }

    public String toString(){
        return "Car=[model: " + model + ", price: "+ price+", new: " + isNew + " ] ";
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

        writeCarsToFile(cars, "Cars.out");
        readCarsFromFile("Cars.out").forEach(System.out::println);
//        Output:
//        Car=[model: Hatchback, price: 0, new: false ]
//        Car=[model: Hatchback, price: 0, new: false ]

    }
}
