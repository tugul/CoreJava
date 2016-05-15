package nio2;

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
 * Keyword transient is used to mark instance variable not to be serialized/to be ignored from serialization
 * Static members of class are ignored to be serialized/de-serialized
 *
 * ObjectInputStream    de-serialize stream into object
 * ObjectOutputStream   serialize object into stream
 *
 * Note: During de-serialization, constructor or any initializer of the serialized class won't be run
 *
 */

class Car implements Serializable {
    private static final int serializedId = 250;
    private static String model;    // String is Serializable
    private transient int price;
    private transient boolean isNew;

    { price += 50; }

    public Car() {
        model = "Sedan";
        price = 100;
        isNew = true;
    }

    public Car(String model, int price, boolean isNew) {
        this.model = model;
        this.price = price;
        this.isNew = isNew;
    }

    public String toString(){
        return "Car=[model: " + model + ", price: "+ price+", new: " + isNew + " ]";
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
        cars.add(new Car("Hatchback", 130, false));

        writeCarsToFile(cars, "Cars.out");
        readCarsFromFile("Cars.out").forEach(System.out::println);
//        Output:
//        Car=[model: Hatchback, price: 0, new: false ]
//        Car=[model: Hatchback, price: 0, new: false ]

    }
}
