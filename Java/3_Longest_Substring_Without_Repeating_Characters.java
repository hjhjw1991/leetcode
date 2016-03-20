/**
Longest Substring Without Repeating Characters 
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        char[] chs=s.toCharArray();
        boolean[] visit=new boolean[256];
        int maxl=1, l=0, r=0;
        while(l<=r&&r<chs.length){
            while(r<chs.length && visit[chs[r]]==false){
                visit[chs[r++]]=true;
            }
            maxl=Math.max(maxl,r-l);
            while(l<r && r<chs.length && chs[l]!=chs[r]){
                visit[chs[l++]]=false;
            }
            l++;
            r++;
        }
        return maxl;
    }
}