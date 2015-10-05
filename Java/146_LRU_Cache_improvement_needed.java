public class LRUCache {
    // it is very easy to understand.
    // but time-taking.
    // Double Linked List will help
class Element {
    int key;
    int value;
    public Element(int k, int v) {
        key = k;
        value = v;
    }
}

LinkedList<Element> cache = new LinkedList<Element>();
HashMap<Integer, Element> hash = new HashMap<Integer, Element>();
int cap = 0;

public LRUCache(int capacity) {
    cap = capacity;
}

public int get(int key) {

    Element e = hash.get(key);
    if (e == null) {
        return -1;
    }

    cache.remove(e);
    cache.add(e);

    return e.value;
}

public void set(int key, int value) {
    int val = get(key);

    if (val == -1) {  // not cached.
        if (cache.size() == cap) {
            Element e = cache.remove();
            hash.remove(e.key);
        }
    } else { // cached, update it.
        cache.removeLast();
    }
    Element e = new Element(key, value);
    cache.add(e);
    hash.remove(e.key);
    hash.put(e.key, e);
}
}