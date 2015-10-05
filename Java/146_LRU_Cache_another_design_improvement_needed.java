import java.util.*;

public class Solution extends Test{
    private int cap;
    private HashMap<Integer, Integer> cache;
    private LinkedList<Integer> keys;
    
    public class LRUCache {
        private int cap;
        private int priority;
        private HashMap<Integer, Integer> cache;
        private HashMap<Integer, Integer> keys;
        
        public LRUCache(int capacity) {
            cap = capacity;
            priority = 0;
            cache = new HashMap<Integer, Integer>();
            keys = new HashMap<Integer, Integer>();
        }
        
        public int get(int key) {
            Integer k = (Integer)key;
            int res;
            for(Integer i:cache.keySet()){
                System.out.printf("[%d %d] ", i, cache.get(i));
            }
            System.out.println();
            if(cache.containsKey(k)){
                keys.put(k, priority++);
                res = cache.get(k);
            }else{
                res = -1;
            }
            return res;
        }
        
        public void set(int key, int value) {
            if(get(key)==-1){
                if(keys.size()==cap){
                    int min=Integer.MAX_VALUE, ind=-1;
                    for(int k:keys.keySet()){
                        if(min>keys.get(k)){
                            min = keys.get(k);
                            ind = k;
                        }
                    }
                    cache.remove(ind);
                }
                keys.put(key, priority++);
                cache.put(key, value);
            }
        }
    }
    
    protected void solve(Scanner sc){
        LRUCache lru = Solution.this.new LRUCache(1);
        lru.set(2,1);
        lru.get(2);
        lru.set(3,2);
        lru.get(2);
        lru.get(3);
    }
    
    public void solve(){
        sc = new Scanner(System.in);
        // below is related to concrete problems
        int T = sc.nextInt();
        //sc.nextLine();//jump over the first line. 
        for(int i=1;i<=T;i++){
            System.out.printf("Case #%d:\n", i);
            solve(sc);
        }
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        so.debug();
        //so.noDebug("2");
        so.solve();
    }
}