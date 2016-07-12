Collections framework has four main data structure types (list, set, queue and map). 
List, set and queue interfaces extends Collection interface. 

##### 1. List — Ordered collection of elements that can duplicate
- ArrayList: Standard resizable list.
- LinkedList: Can easily add/remove from beginning or end.
- Vector: Older version of ArrayList, thread-safe.
- Stack: Older last-in, first-out class.

##### 2. Set —Does not allow duplicates
- HashSet: Uses hashcode() to find unordered elements.
- TreeSet: Sorted and navigable. Does not allow null values.

##### 3. Queue —Orders elements for processing
- LinkedList: Can easily add/remove from beginning or end.
- ArrayDeque: First-in, first-out or last-in, first-out. Does not allow null values.

##### 4. Map —Maps unique keys to values
- HashMap: Uses hashcode() to find keys, allows null key
- TreeMap: Sorted map. Does not allow null keys.
- HashTable: Older version of HashMap. Does not allow null keys or values.
