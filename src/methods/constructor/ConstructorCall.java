package methods.constructor;

/**
 * First line in a constructor is implicit call (if not explicitly written) to own other constructors or parent class's constructor
 * If parent class doesn't have default constructor, child constructor must EXPLICITLY call parent's non default constructor
 */

class Animal {  // Does not have default constructor
    Animal(int i) { }
    Animal(boolean b) { }
}

class Dog extends Animal {
    //Dog (){}          // DOES NOT COMPILE

    Dog() {
        this(5); //super(6);     // Mandatory call to parent's constructor
    }

    Dog(int a) {
        super(true);  // Mandatory call to parent's constructor
    }
}

// Below 3 classes are equivalent because compiler converts them too last one
class Pet1 {
}

class Pet2 {
    Pet2() {}
}

class Pet3 {
    Pet3(){
        super();
    }
}

public class ConstructorCall {
    public static void main(String[] args) {
    }
}
