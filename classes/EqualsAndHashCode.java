package classes;

/**
 *
 * - equals()
 * for defining equivalence relation (reflexive, transitive, symmetric)
 * must be consistent until object is modified
 * used when search inside collection (e.g. contains, remove ...)
 * tells whether you have found exact match
 * default implementation in Object class use operator '='
 *
 * - hashCode()
 * must return consistent integer value for object during application execution
 * used when inserting object into hashtable, hashmap or hashset
 * tells which bucket to look in
 * default implementation in Object class provides memory address
 *
 * - Note
 * if override one of them, then necessary to override the other one too
 * if override, both must be public
 * same set of fields should be used to compute both
 * If a.equals(b), then a.hashCode() and b.hashCode() must be same
 * same hashcode for two objects doesn't guarantee one equals to other
 */
public class EqualsAndHashCode {
	String name;
	int versionId;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EqualsAndHashCode)
			return this.name.equals(((EqualsAndHashCode)obj).name) &&  
				   this.versionId == ((EqualsAndHashCode)obj).versionId;
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + versionId * 19;
	}
}
