package methods.constructor;

/**
 1. Public class's static field/initializers
 2. Main method
 3. Most parent till last child classes' static field/initializers
 4. Most parent class's instance field/initializers
 5. Most parent class's instance constructor
 ...
 6. Last child class's instance field/initializers
 7. Last child class's instance constructor

 Static initializer in public class
 Main started
 Static initializer: GrandPa
 Static initializer: Papa
 Static initializer: Child
 Instance initializer: GrandPa
 Constructor: GrandPa
 Instance initializer: Papa
 Constructor: Papa
 Instance initializer: Child
 Constructor: Child
 Instance initializer: GrandPa
 Constructor: GrandPa

 */
class GrandPa {
    static
    { System.out.println("Static initializer: GrandPa"); }
    { System.out.println("Instance initializer: GrandPa"); }

    GrandPa() {
        System.out.println("Constructor: GrandPa");
    }
}

class Papa extends GrandPa {
    static
    { System.out.println("Static initializer: Papa"); }
    { System.out.println("Instance initializer: Papa"); }

    Papa (){
        System.out.println("Constructor: Papa");
    }
}

class Child extends Papa {
    static
    { System.out.println("Static initializer: Child"); }
    { System.out.println("Instance initializer: Child"); }

    Child (){
        System.out.println("Constructor: Child");
    }
}


public class InitializationOrder {
    static {
        System.out.println("Static initializer in public class");
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        InitializationOrder order = new InitializationOrder();
        Child child = new Child();
        GrandPa grandPa = new GrandPa();
    }
}
