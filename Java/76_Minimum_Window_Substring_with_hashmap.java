public class Solution {
    public String minWindow(String s, String L){  
    int min=s.length(),start=0;
    if(s==null || s.length()==0 || L==null || L.length()==0)  
        return "";  
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    HashMap<Character,Integer> curMap = new HashMap<Character,Integer>();
    for(int i=0;i<L.length();i++)  
    {  
        if(map.containsKey(L.charAt(i)))
        {  
            map.put(L.charAt(i),map.get(L.charAt(i))+1);  
        }  
        else  
        {  
            map.put(L.charAt(i),1);
        }  
        curMap.put(L.charAt(i),0);
    }
    int right=0,left=0,count=0;
    char c;
    int minLeft=0,minRight=s.length();
    while(right<s.length())
    {
            c = s.charAt(right);
            if(!map.containsKey(c))  
            {  
                right++;
                continue;
            }
            curMap.put(c, curMap.get(c)+1);
            if(curMap.get(c)<=map.get(c)){
                count++;
            }
            if(count==L.length()){
                while(left<right){
                    c = s.charAt(left);
                    if(!map.containsKey(c)){
                        left++;
                        continue;
                    }
                    if(curMap.get(c)>map.get(c)){
                        curMap.put(c, curMap.get(c)-1);
                        left++;
                        continue;
                    }else{
                        break;
                    }
                }
            if(right - left < minRight - minLeft){
                minRight = right;
                minLeft = left;
            }
            }
            right++;
    }
    if(minRight==s.length()){
        return "";
    }
    return s.substring(minLeft, minRight+1);
    }
}