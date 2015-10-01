public class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()<1)return true;
        char[] par = s.toCharArray();
        int i=0;
        int[] dp = new int[par.length+1];// dp[i] to save index of last open parenthese before i
        dp[0]=-1;
        for(;i<par.length;i++){
            switch(par[i]){
                case '(':
                case '[':
                case '{':
                    dp[i+1]=i;
                    break;
                case ')':
                case ']':
                case '}':
                    if(dp[i]==-1)return false;
                    else if(par[i]==')' && par[dp[i]]=='(' || par[i]==']' && par[dp[i]]=='[' || par[i]=='}' && par[dp[i]]=='{')
                        dp[i+1]=dp[dp[i]];// pass last open parenthese
                    else{
                        return false;
                    }
            }
        }
        return dp[par.length]==-1;
    }
}