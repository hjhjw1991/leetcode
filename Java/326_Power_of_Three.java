public class Solution {
    public boolean isPowerOfThree(int n) {
        //how to solve it without any loop/recursion?
        if(n<=0)return false;
        return subWithMod(n);
    }
    
    public boolean subWithMultiply(int n){
        int i=1;
        while(i<n&&i<(i<<1)+i){// handle overflow
            i=(i<<1)+i;
        }
        return i==n;
    }
    
    public boolean subWithDivision(int n){
        while(n%3==0){
            n=n/3;
        }
        return n==1;
    }
    
    public boolean subWithMod(int n){
        int MOST_POWER = 1162261467; // the largest power of 3 less than Integer.MAX_VALUE. It hides the loop/recursion of get it.
        return MOST_POWER % n ==0;
    }
}