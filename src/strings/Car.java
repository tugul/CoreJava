package strings;

/**
 * Created by bbn on 4/8/16.
 */
public class Car {
    String type = "Hatchbag";
    int speed = 100;

    Car() {
    }

    Car(int speed, String type) {
        this.speed = speed;
        this.type = type;
    }
}

class Prosche extends Car {
    String name;

    Prosche(String name) {
        super();
        this.name = name;
    }

    Prosche(int speed, String type, String name) {
        super(speed, type);
        this.name = name;
    }

}

