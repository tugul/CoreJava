package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * - Raw type
 * It is class or interface whose generic type is not explicitly provided
 * It is less expressive
 * Using raw type loose type safety
 * So not recommended to use
 */

class Shape<T> { }
class Rectangle extends Shape {}	// Shape is now raw type as it is not parameterized 

public class RawType {
	public static void main(String[] args) {		
		List rawType = new ArrayList<>();
		rawType.add(true);
		rawType.add(new Object());
		
		List<Object> objects = new ArrayList<>();
		objects.add(true);
		objects.add(new Object());
		
		rawType = new ArrayList<String>();	// List<String> is a subtype of raw type List 
		objects = new ArrayList<String>(); 	// DOES NOT COMPILE, List<String> is not subtype of List<Object>
		
		Shape rawType1 = new Shape();			// raw type
		Shape<RawType> rawType2 = new Shape();	// raw type
		Shape<Integer> genericType = new Shape<>();
	}
}
