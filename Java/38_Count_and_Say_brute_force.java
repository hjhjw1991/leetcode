public class Solution {
    public String countAndSay(int n) {
        String str=new String("1");
        if(n<=1)return str;
        for(int i=1;i<n;i++){
            str=count(str);
        }
        return str;
    }
    
    public String count(String str){// generate next String
        char last = str.charAt(0);
        StringBuffer next = new StringBuffer();
        int cnt=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                cnt++;
            }else{
                next.append(String.valueOf(cnt)+last);
                last=str.charAt(i);
                cnt=1;
            }
        }
        next.append(String.valueOf(cnt)+last);
        return next.toString();
    }
}