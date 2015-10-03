public class Solution {
    public int strStr(String haystack, String needle) {
        // this problem can be solved by KMP algorithm or Boyer-Moore algorithm
        // but brute force is good enough. It covers every corner case, and is not easy to be written in a wrong way
        if(haystack==null||needle==null)return -1;
        int i;
        for(i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                break;
            }
        }
        return i<haystack.length()-needle.length()+1?i:-1;
    }
}