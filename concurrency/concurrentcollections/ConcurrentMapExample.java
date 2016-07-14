package concurrency.concurrentcollection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Below 2 classes have thread safety
 *
 * - SynchronizedMapData
 * used synchronized methods to access its map data
 *
 * - ConcurrentMapData
 * uses built-in ConcurrentHashMap which does same as synchronized access methods
 *
 */

class SynchronizedMapData {
    private Map<String, String> data = new HashMap<>();

    public synchronized void put(String key, String value) {
        data.put(key, value);
    }
    public synchronized String get(String key) {
        return data.get(key);
    }
}

class ConcurrentMapData {
    private Map<String, String> data = new ConcurrentHashMap<>();
    public void put(String key, String value) {
        data.put(key, value);
    }
    public String get(String key) {
        return data.get(key);
    }
}

public class ConcurrentMapExample {
    public static void main(String[] args) {

    }
}
