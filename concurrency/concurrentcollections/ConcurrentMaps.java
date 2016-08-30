package concurrency.concurrentcollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * - Concurrent maps
 * Changes in data during iteration are immediately reflects to original data
 * 
 * ConcurrentHashMap : implements ConcurrentMap, 
 * ConcurrentSkipListMap : implements ConcurrentMap, also NavigableMap so its keys are sorted
 * those Map classes don't accept null in key or value.
 * TreeMap - accepts null in value, but not in key
 * HashMap - accepts null in both of key and value
 * Similarly, ConcurrentSkipListSet and TreeSet don't accept null while HashSet accepts null
 * 
 * - Below 2 classes have thread safety, but in different ways:
 * class SynchronizedMapData
 * class ConcurrentMapData
 * 
 */

// It used synchronized methods to access its map data
class SynchronizedMapData {
    private Map<String, String> data = new HashMap<>();

    public synchronized void put(String key, String value) {
        data.put(key, value);
    }
    public synchronized String get(String key) {
        return data.get(key);
    }
}

// It uses built-in ConcurrentHashMap which does same as synchronized access methods
class ConcurrentMapData {
    private Map<String, String> data = new ConcurrentHashMap<>();
    public void put(String key, String value) {
        data.put(key, value);
    }
    public String get(String key) {
        return data.get(key);
    }
}

public class ConcurrentMaps {
    public static void main(String[] args) {
    	// Non-concurrent map
    	Map<String, String> hashMap = new HashMap<>();
    	hashMap.put("a", "1");
    	hashMap.put("b", "2");
    	hashMap.put("c", "3");
    	for(String key : hashMap.keySet())
    		hashMap.remove(key);    	// throws ConcurrentModificationException
    	
    	// Concurrent map
    	Map<String, String> concurrentMap = new ConcurrentHashMap<>();
    	concurrentMap.put("a", "1");
    	concurrentMap.put("b", "2");
    	concurrentMap.put("c", "3");
    	concurrentMap.put(null, "3");	// throws NullPointerException, doesn't accept NULL in key and value
    	concurrentMap.put("d", null);	// throws NullPointerException
    	
    	System.out.println(concurrentMap);	// {a=1, b=2, c=3}
    	for(String key : concurrentMap.keySet())
    		concurrentMap.remove(key);		// keySet() is updated immediately when object is removed
    	
    	System.out.println(concurrentMap);	// {}
    }
}
