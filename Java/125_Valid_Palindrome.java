public class Solution {
public boolean isPalindrome(String s) {
    if(s==null) return false;
    if(s.length()==1) return true;
    s=s.toUpperCase();
    int i=0;
    int j=s.length()-1;
    while(i<j){
        if(!(s.charAt(i)>47 && s.charAt(i)<58 || s.charAt(i)>64 && s.charAt(i)<91 ) ){
            i++;
            continue;
        }
        if(!(s.charAt(j)>47 && s.charAt(j)<58 || s.charAt(j)>64 && s.charAt(j)<91 ) ){
            j--;
            continue;
        }
        if(s.charAt(i)!=s.charAt(j)) return false;
        i++;
        j--;
    }

    return true;
}
}