public class Solution {
    // 动态规划的想法：
    // 两个字符串，分别出前i个和前j个，他们能否组成s3的前i+j个，取决于前i+j-1个字符的情况以及第i+j个字符的情况
    // isInterleave(i, j) = isInterleave(i, j-1) and s2(j)==s3(i+j) || isInterleave(i-1, j) and s1(i)==s3(i+j)
    // 讨论第i+j个字符来自哪个字符串即可
    // 边界条件是有一方出0个字符时的情况
    // 返回结果是dp[len(s1)][len(s2)]
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        int len1=s1.length(),len2=s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0]=s3.length()==0;
        for(int i=1;i<=len1;i++){
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i=1;i<=len2;i++){
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j] = dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1) || dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
            }
        }
        return dp[len1][len2];
    }
}