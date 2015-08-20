import java.util.TreeSet;
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=6){
            return n;
        }
        TreeSet<Long> set=new TreeSet<Long>();
        set.add(1l);
        long num=0;
        while(n>0){
            num=set.pollFirst();
            set.add(num*2);
            set.add(num*3);
            set.add(num*5);
            n--;
        }
        return (int)num;
    }
}