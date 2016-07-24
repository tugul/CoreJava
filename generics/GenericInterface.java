package generics;

/**
 * Generic interface
 * 3 ways to implement generic interface:
 * 1. Concrete class provides specific type
 * 2. Concrete class continues using generic type
 * 3. Concrete class doesn't use generics at all
 * Last one is old way of coding and Java 8 generates compiler warning about this raw type
 */

class Box {}

interface IPackable<T> {
    void pack(T t);
}

// 1. provides specific type
class BoxPacker implements IPackable<Box> {
    public void pack(Box box){}
}

// 2. continues using generic type
class Packer<T> implements IPackable<T> {
    public void pack(T t){}
}

// 3. not using generics triggers raw type warning
class OldPacker implements IPackable {
    public void pack(Object o) {}	// Overriding method, T must be type Object in this case 
    public void pack(Box b) {}		// Overloading method
}
