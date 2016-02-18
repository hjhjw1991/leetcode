public class Solution {
/* TLE
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes==null||primes.length==0)return 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        HashSet<Integer> hasOccur = new HashSet<>();
        heap.add(1);
        hasOccur.add(1);
        int i=0, cur=0, c;
        while(heap.size()>0&&i<n){
            cur = heap.poll();
            for(int k:primes){
                c = k*cur;
                if(!hasOccur.contains(c)){
                    heap.add(c);
                    hasOccur.add(c);
                }
            }
            i++;
        }
        return cur;
    }
*/
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes==null||primes.length==0)return 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        HashSet<Integer> hasOccur = new HashSet<>();
        heap.add(1);
        hasOccur.add(1);
        int i=0, cur=0, c;
        while(heap.size()>0&&i<n){
            cur = heap.poll();
            for(int k:primes){
                c = k*cur;
                if(!hasOccur.contains(c)){
                    heap.add(c);
                    hasOccur.add(c);
                }
            }
            i++;
        }
        return cur;
    }
    public static void main(String[] argv){
        System.out.println(nthSuperUglyNumber(100000, new int[]{2,3,5}));
    }
}