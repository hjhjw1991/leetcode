public class Solution {
    public String getHint(String secret, String guess) {
        if(guess.equals(""))return "";
        final String A="A", B="B";
        char[] sec = secret.toCharArray();
        char[] gue = guess.toCharArray();
        int[] map = new int[10];
        int a=0,b=0;
        for(int i=0;i<gue.length;i++){
            if(sec[i]==gue[i])a++;
            else{
                map[sec[i]-'0']++;
            }
        }
        
        for(int i=0;i<gue.length;i++){
            if(sec[i]==gue[i])continue;
            else{
                if(map[gue[i]-'0']>0){
                    b++;
                    map[gue[i]-'0']--;
                }
            }
        }
        
        return a+A+b+B;
    }
}