public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null)return s1==s2;
        if(s1.length()!=s2.length())return false;
        else if(s1.equals(s2))return true;
        HashMap<String, HashMap<String, Boolean>> dp = new HashMap<String, HashMap<String, Boolean>>();
        return isScram(s1, s2, dp);// 两层hashmap保存状态
    }
    
    public boolean isScram(String s1, String s2, HashMap<String, HashMap<String, Boolean>> dp){
        HashMap<String, Boolean> map = null;
        if(s1==null||s2==null){
            return s1==null&&s2==null;
        }
        if(s1.length()!=s2.length())return false;
        int len=s1.length();
        if(dp.containsKey(s1)){
            map = dp.get(s1);
            if(map.containsKey(s2)){
                return map.get(s2);
            }
        }
        if(map==null){
            map = new HashMap<String, Boolean>();
        }
        map.put(s2, s1.equals(s2));
        dp.put(s1, map);
        for(int i=1;i<len;i++){
            if((isScram(s1.substring(0, i), s2.substring(0, i), dp) && isScram(s1.substring(i), s2.substring(i), dp)) || (isScram(s1.substring(0, i), s2.substring(len-i), dp) && isScram(s1.substring(i), s2.substring(0, len-i), dp))){
                // 注意 substring的接口，如果只有一个数字，则它是起始下标而不是终止下标
                map.put(s2, true);
                break;
            }
        }
        return map.get(s2);
    }
}