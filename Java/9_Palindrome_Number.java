public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;// negative number is considered as non palindrome
        // time O(len(x)), space O(1);
        int y=0, tmp=x;
        while(tmp!=0){
            y=y*10+tmp%10;// watch out! it may overflow here
            tmp/=10;
        }
        return y==x;
    }
}