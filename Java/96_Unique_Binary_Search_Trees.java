import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        if(n<2){
            return n;
        }
        int sum;
        for(int i=2;i<=n;i++){
            sum=0;
            for(int j=0;j<i;j++){
                sum+=dp[j]*dp[i-j-1];
            }
            dp[i]=sum;
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n=3;
        int res = new Solution().numTrees(n);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(List<List<String>> ll){
        int i=0;
        for(List<String> l:ll){
            System.out.println("case " + i++);
            for(String s:l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
//另附N皇后问题的构造解法 http://blog.sina.com.cn/s/blog_49f9e4fc0100c6n4.html