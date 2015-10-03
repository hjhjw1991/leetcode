public class Solution {
    // using DFA state machine
    // there are 11 states, including the start state and two stop states.
    // return false is the false stop. stat 7 is the true stop
    public boolean isNumber(String s) {
        if(s==null||s.length()<1)return false;
        char[] digits = s.toCharArray();
        int stat=-2;
        int i=0,len=digits.length;
        while(i<=len){
            switch(stat){
            case -2:
                while(i<len&&digits[i]==' ')i++;
                if(i==len)return false;
                else if(digits[i]=='-'||digits[i]=='+')stat=-1;
                else if(digits[i]=='.')stat=1;
                else if(digits[i]<='9'&&digits[i]>='0')stat=2;
                else{
                    return false;
                }
                break;
            case -1:
                if(i==len)return false;
                else if(digits[i]=='.')stat=1;
                else if(digits[i]<='9'&&digits[i]>='0')stat=2;
                else{
                    return false;
                }
                break;
            case 1:
                if(i==len)return false;
                else if(digits[i]<='9'&&digits[i]>='0')stat=3;
                else{
                    return false;
                }
                break;
            case 2:
                while(i<len&&digits[i]<='9'&&digits[i]>='0')i++;
                if(i==len)stat=7;
                else if(digits[i]=='.')stat=4;
                else if(digits[i]=='e')stat=5;
                else if(digits[i]==' '){
                    stat=7;
                }else{
                    return false;
                }
                break;
            case 3:
                while(i<len&&digits[i]<='9'&&digits[i]>='0')i++;
                if(i==len)stat=7;
                else if(digits[i]=='e')stat=5;
                else if(digits[i]==' '){
                    stat=7;
                }else{
                    return false;
                }
                break;
            case 4:
                if(i==len)stat=7;
                else if(digits[i]<='9'&&digits[i]>='0')stat=3;
                else if(digits[i]=='e'){
                    stat=5;
                }else if(digits[i]==' '){
                    stat=7;
                }else{
                    return false;
                }
                break;
            case 5:
                if(i==len)return false;
                else if(i<len&&digits[i]<='9'&&digits[i]>='0')stat=6;
                else if(digits[i]=='+'||digits[i]=='-'){// it is another state, which is handled here
                    i++;
                    if(i<len&&digits[i]<='9'&&digits[i]>='0')stat=6;
                    else return false;
                }else{
                    return false;
                }
                break;
            case 6:
                while(i<len&&digits[i]<='9'&&digits[i]>='0')i++;
                if(i==len)stat=7;
                else if(digits[i]==' '){
                    stat=7;
                }else{
                    return false;
                }
                break;
            case 7:
                while(i<len&&digits[i]==' ')i++;
                if(i<len)return false;
                break;
            }
            i++;
        }
        return stat==7;
    }
}