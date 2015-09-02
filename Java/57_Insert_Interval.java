import java.util.*;

public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if(intervals.size()==0){
            ret.add(newInterval);
            return ret;
        }
        Interval in;
        int i=0, length=intervals.size();
        if(intervals.get(length-1).end < newInterval.start){
            intervals.add(newInterval);
            return intervals;
        }else if(intervals.get(0).start > newInterval.end){
            ret.add(newInterval);
            ret.addAll(intervals);
            return ret;
        }
        while(i<length){
            in = intervals.get(i++);
            if(in.end>=newInterval.start&&in.start<=newInterval.end){
                in.start=Math.min(in.start, newInterval.start);
                in.end=Math.max(in.end, newInterval.end);
                while(i<length&&intervals.get(i).start<=newInterval.end){
                    in.end=Math.max(in.end, intervals.get(i).end);
                    i++;
                }
            }else{
                if(in.end<newInterval.start && i<length && intervals.get(i).start>newInterval.end){
                    ret.add(in);
                    ret.add(newInterval);
                    in = intervals.get(i++);
                }
            }
            ret.add(in);
        }
        return ret;
    }
    
    // another not so good solution is to add the new interval to list and sort and merge
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
        for(int i=0;i<=15;i+=4){
            in = so.new Interval(i, i+2);
            intervals.add(in);
        }
        print(intervals);
        print(so.insert(intervals, so.new Interval(7,7)));
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