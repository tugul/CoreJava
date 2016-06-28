package generics;


/**
 * - Type erasure
 * Generic types are replaced/erased by compiler to type Object
 * In other words, generic type and Object type are same in compile time, 
 * So below it two methods have same signature 
 */
public class TypeErasure<T> {
	void method(T t) {}			// DOES NOT COMPILE
	void method(Object o) {}	// DOES NOT COMPILE
}
