import java.util.*;

public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    // 按照起点从小到大排序，挨个合并终点
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new MyComparator());
        List<Interval> ret = new ArrayList<Interval>();
        Interval in, ne;
        int i=0;
        while(i<intervals.size()){
            in=intervals.get(i++);
            while(i<intervals.size() && in.end >= intervals.get(i).start){
                in.end = Math.max(in.end, intervals.get(i).end);
                i++;
            }
            ret.add(in);
        }
        return ret;
    }
    
    public class MyComparator implements Comparator{
        public int compare(Object o1, Object o2){
            Interval oo1 = (Interval)o1;
            Interval oo2 = (Interval)o2;
            return oo1.start-oo2.start;
        }
    }
    
    public static void main(String argv[]){
        Solution so=new Solution();
        //int[] input={-3,-2,-1,0,0,1,2,3};
        List<Interval> intervals= new ArrayList<Interval>();
        Interval in;
        for(int i=1;i>0;i--){
            in = so.new Interval(i, i+5);
            intervals.add(in);
        }
        print(intervals);
        print(so.merge(intervals));
    }
    static void print(List<Interval> l){
        int i=0;
        for(Interval in:l){
            System.out.print(i++);
            System.out.print("\t");
            System.out.print(in.start);
            System.out.print("\t");
            System.out.print(in.end);
            System.out.print("\t");
        }
            System.out.println();
    }
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
}