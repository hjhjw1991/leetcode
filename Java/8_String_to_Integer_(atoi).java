public class Solution {
    // the rule is :
    // 1. leading whitespaces are ignored, while whitespaces after valid number are illegal
    // 2. plus or minus operator is allowed, only ahead of the string
    // 3. when result is greater than Integer.MAX_VALUE(2147483647) or less than Inter.MIN_VALUE(-2147483648), return the boundary value
    // 4. a string with a valid number followed with an invalid substring left should only return the valid part.
    public int myAtoi(String str) {
        if(str==null||str.length()==0)return 0;
        char[] chars = str.toCharArray();
        int i=0;
        while(chars[i]==' ')i++;
        char cur;
        long res=0;// long is used to handle the case of overflow. if res is of int type, we should consider converting the *10 part into long, in order to compare with the MAX_VALUE and get the correct result.
        int flag=1;
        // handle the positive/negative flag
        if(chars[i]=='+'){
            i++;
        }else if(chars[i]=='-'){
            flag=-1;
            i++;
        }
        while(i<chars.length){
            if(chars[i]>'9'||chars[i]<'0')return (int)res*flag;// return the valid part
            else{
                if(res*10+chars[i]-'0'>=Integer.MAX_VALUE && flag>0 || res*10+chars[i]-'0'>Integer.MAX_VALUE && flag<0){
                    res = flag>0? Integer.MAX_VALUE: Integer.MIN_VALUE;
                    return (int)res;// overflow
                }
                res*=10;
                res+=chars[i]-'0';
            }
            i++;
        }
        return (int)res*flag;// return the result
    }
}