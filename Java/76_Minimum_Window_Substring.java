import java.util.*;
import dutil.*;

public class Solution {
    public String minWindow(String s, String L){  
        int min=s.length(),start=0;
        if(s==null || s.length()==0 || L==null || L.length()==0)  
            return "";  
        char[] str = s.toCharArray();
        char[] temp = L.toCharArray();
        int[] map = new int[128];
        int[] find = new int[128];// used as HashMap
        int minL=0;
        int minR=str.length;
        for(int i=0;i<temp.length;i++)  
        {
            map[temp[i]]++;
        }
        int left=0,right=0,count=0;// two pointer
        while(right<str.length){
            if(map[str[right]]==0){
                right++;
                continue;
            }
            find[str[right]]++;
            if(find[str[right]] <= map[str[right]]){
                count++;
            }
            if(count==temp.length){
                while(left<right){
                    if(map[str[left]]==0){
                        left++;
                        continue;
                    }
                    if(find[str[left]]>map[str[left]]){
                        find[str[left]]--;
                        left++;
                        continue;
                    }else{
                        break;
                    }
                }
                if(right-left<minR - minL){
                    minL=left;
                    minR=right;
                }
            }
            right++;
        }
        if(minR==str.length){
            return "";
        }
        return s.substring(minL, minR+1);
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        Print p=new Print();
        String[] cases = {
            "ADOBECODEBANC",
        };
        for(String s:cases){
            p.print(so.minWindow(s, "COD"));
        }
    }
}