package classes;

/**
 *
 * equals()
 * - for defining equivalence relation (reflexive, transitive, symmetric)
 * - must be consistent until object is modified
 * - tells whether you have found exact match
 *
 * hashcode()
 * - must return consistent integer value for object during application execution
 * - tells which bucket to look in
 *
 * Note
 * - if override one, then override other one too
 * - same set of fields should be used to compute both
 * - If a.equals(b), then a.hashcode() and b.hashcode() must be same
 * - same hashcode for two object doesn't guarantee one equals to other
 */
public class EqualsAndHashCode {
}
