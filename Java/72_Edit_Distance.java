import java.util.*;

public class Solution {
    // I wrote the DP algorithm with my instinct, but I was not sure whether it was correct!
    public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0){
            return word2==null?0:word2.length();
        }else if(word2==null||word2.length()==0){
            return word1.length();
        }else if(word1.equals(word2)){
            return 0;
        }
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];
        for(int i=0;i<=str2.length;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=str1.length;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){
                dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);// add a char or delete a char
                if(str1[i-1]!=str2[j-1]){
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,dp[i][j]);// replace a char
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j]);// replace a char
                }
            }
        }
        return dp[str1.length][str2.length];
    }
    
    public static void main(String argv[]){
        String word1 = "What";
        String word2 = "Whin";//3
        Solution so=new Solution();
        print(word1);
        print(word2);
        print(so.minDistance(word1, word2));
    }
    
    static void print(List<String> list){
        for(String s:list){
            print(s);
        }
    }
    static void print(int[] num, String delimiter){
        if(delimiter==null)delimiter="\t";
        for(int n:num){
            System.out.print(n);
            System.out.print(delimiter);
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
    
    static void print(String str){
        System.out.println(str);
    }
}