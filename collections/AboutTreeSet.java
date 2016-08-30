package collections;

import java.util.TreeSet;

/**
 * - TreeSet
 * it has unique and sorted elements in natural order
 * String values are ordered according to their ASCII code. Increasing order 0-9 ... A-Z ...a-z
 * 
 * - Constructors
 * TreeSet()
 * TreeSet(Comparator)
 * TreeSet(Collection)
 * 
 * - Some methods
 * E ceiling(E) - returns least element which is greater than or equal to given value 
 * E floor(E) - returns highest element which is less than or equal to given value
 * E higher(E) - returns least element which is greater than given value
 * E lower(E) - returns highest element which is less than given value
 * 
 */
public class AboutTreeSet {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("Two");
		treeSet.add("two");
		treeSet.add("TWO");
		treeSet.add("1");
		treeSet.add("2");
		
		System.out.println(treeSet);	// [1, 2, TWO, Two, two]
		
		System.out.println(treeSet.ceiling("TWO"));		// TWO
		System.out.println(treeSet.floor("TWO"));		// TWO

		System.out.println(treeSet.ceiling("3"));		// TWO
		System.out.println(treeSet.floor("3"));			// 2
		
		System.out.println(treeSet.higher("TWO"));		// Two
		System.out.println(treeSet.lower("TWO"));		// 2
	}
}
