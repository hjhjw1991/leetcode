public class Solution {
    public int climbStairs(int n) {
        // 斐波那契数列
        if(n<=1) return 1;// 小于等于1则返回1
        int a=1,b=2;
        while(n>2){
            b=b+a;
            a=b-a;
            n--;
        }
        return b;// 对于返回类型int来说，n超过一定限度会溢出，这种情况leetcode的测例并没有考虑
    }
}