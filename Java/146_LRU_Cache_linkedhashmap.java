import java.util.*;
// from http://blog.csdn.net/beiyeqingteng/article/details/7010411
// using LinkedHashMap, which is implemented with double linked list
public class LRUCache{

    private static final float   hashTableLoadFactor = 0.75f;// load factor

    private LinkedHashMap<Integer, Integer> map;
    private int cacheSize;

    /** 
    * Creates a new LRU cache. 
    * @param cacheSize the maximum number of entries that will be kept in this cache. 
    */  
    public LRUCache (int cacheSize) {  
        this.cacheSize = cacheSize;  
        int hashTableCapacity = (int)Math.ceil(cacheSize / hashTableLoadFactor) + 1;  
        map = new LinkedHashMap<Integer, Integer>(hashTableCapacity, hashTableLoadFactor, true) {  
            // (an anonymous inner class)
            private static final long serialVersionUID = 1;  
            @Override
            protected boolean removeEldestEntry (Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.cacheSize;
            }
        };
    }
  
    /** 
    * Retrieves an entry from the cache.<br> 
    * The retrieved entry becomes the MRU (most recently used) entry. 
    * @param key the key whose associated value is to be returned. 
    * @return    the value associated to this key, or null if no value with this key exists in the cache. 
    */  
    public synchronized Integer get (Integer key) {
       Integer res = map.get(key);
       return res==null?-1:res;
    }

    /** 
    * Adds an entry to this cache. 
    * The new entry becomes the MRU (most recently used) entry. 
    * If an entry with the specified key already exists in the cache, it is replaced by the new entry. 
    * If the cache is full, the LRU (least recently used) entry is removed from the cache. 
    * @param key    the key with which the specified value is to be associated. 
    * @param value  a value to be associated with the specified key. 
    */  
    public synchronized void set (Integer key, Integer value) {
        map.put (key, value);
    }
}