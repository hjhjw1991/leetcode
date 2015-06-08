/**
214. Shortest Palindrome 
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        int len=s.length();
        if(len<=1){
            return s;
        }
        String ahead=null;
        int j=len;
        for(int i=len;i>=0;i--){
            if(isPalindrome(s.substring(0,i))){
                j=i;
                break;
            }
        }
        if(j==len){
            return s;
        }else{
            StringBuffer sb=new StringBuffer(s.substring(j));
            return sb.reverse().toString()+s;
        }
    }
    
    public boolean isPalindrome(String s){
        int len=s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        Solution sl=new Solution();
        String[] cases = {"aacecaaa",
                            "abcd",
                            "aaceaaa",
                            "a",
                            "aa",
                            "abcecbb"
                            };
        for(String s : cases){
            System.out.println(s+"\t"+sl.shortestPalindrome(s));
        }
    }
}