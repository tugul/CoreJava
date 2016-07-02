package generics;

/**
 * - Type erasure
 * Generic types are replaced/erased by compiler to type Object
 * In other words, generic type and Object type are same in compile time, 
 * Below two methods have same signature, thus won't compile 
 */
public class TypeErasure<T> {
	void method(T t) {}			// DOES NOT COMPILE
	void method(Object o) {}	// DOES NOT COMPILE
}
