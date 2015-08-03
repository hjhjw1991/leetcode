public class Solution {
    public boolean isMatch(String s, String p) {
        // DP
        boolean opt[] = new boolean[p.length()+1];
        boolean pre[] = new boolean[p.length()+1];
        // base case
        pre[0] = true;
        boolean valid = false;
        for(int j = 2;j <= p.length();j+=2){
            if(p.charAt(j-1)=='*'){ valid = true; pre[j] = true;}
            else{ valid = false;}
            if(!valid) break;
        }
        // iteration
        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= p.length();j++){
                opt[j] = false;
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') opt[j] = pre[j-1];
                else if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
                        opt[j] = pre[j] || opt[j-2];
                    else
                        opt[j] = opt[j-2];
                }
            }
            for(int j = 0;j <= p.length();j++)
                pre[j] = opt[j];
        }
        return pre[p.length()];
    }
}