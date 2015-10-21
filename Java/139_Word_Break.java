public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // 这个题有一个很自然的递归解法：
        // for(int i=1;i<s.length();i++){
        //     if(wordDict.contains(s.substring(0,i)) && wordBreak(s.substring(i), wordDict))return true;
        // }
        // return false;
        // 但几乎可以肯定这种解法一定会超时，因为对于同一个子串它进行了很多次的计算
        // 那么我们可以很自然地想到，保存状态，动态规划
        // 好，那么保存什么状态呢？
        // 我们发现，每次计算的时候实际上只是看某一个区间的子串是不是单词表中的单词而已，那么我们可以保存这个状态，用一个二维dp数组
        // 更进一步，我们也许只需要保存s中前k个字母是不是可以分解成wordDict中的单词，这一个结论就可以了
        // 按照这样的思路，可以构造一维状态数组dp，dp[i]表示前i个字母的子串是否可以分割成单词，初始状态dp[0]=true，其余均为false
        if(s==null||s.length()==0)return true;
        if(wordDict.size()==0)return false;// 别忘了边界条件，判空
        int len=s.length();
        boolean[] dp=new boolean[len+1];// 注意由于存在前0个的状态，这里要多申请一个空间
        dp[0]=true;
        for(int i=1;i<=len;i++){// 对于[0,i]的子串
            for(int j=i-1;j>=0;j--){// 尝试每一个可能的分割位置。倒着扫描的原因是每次试探的单词[j,i]一般是较短的，倒着更有可能尽快找到单词分割
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;// 只要找到一个分组方式，则该dp[i]状态已经确定
                }
            }
        }
        return dp[len];
    }
}