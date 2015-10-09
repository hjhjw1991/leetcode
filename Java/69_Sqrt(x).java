public class Solution {
    public int mySqrt(int x) {
        // 二分查找，否则暴力法会超时
        if(x<=0) return x;
        else if(x<4) return 1;
        long left = 1;
        long right = 2;
        while(right*right<x){left = right; right=right<<1;}// 找到x落在的2次幂区间。这里注意，如果x很大，右边界可能溢出int，所以要用long
        long  mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid<x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int)right;//~
    }
}