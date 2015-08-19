import java.util.ArrayList;
import java.util.HashMap;

public class Solution{
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        StringBuffer sb=new StringBuffer();
        int pos=0,carry=0,step=0,v,factor1,factor2;
        int[] n1=new int[num1.length()];
        int[] n2=new int[num2.length()];
        for(pos=0;pos<n1.length;pos++){
            n1[pos]=num1.charAt(pos)-'0';
        }
        for(pos=0;pos<n2.length;pos++){
            n2[pos]=num2.charAt(pos)-'0';
        }
        for(factor2=n2.length-1;factor2>=0;factor2--){
            pos=step;
            for(factor1=n1.length-1;factor1>=0;factor1--){
                v=n2[factor2]*n1[factor1]+carry;
                if(pos<sb.length()){
                    v+=sb.charAt(pos)-'0';
                    sb.setCharAt(pos,(char)(v%10+'0'));
                }else{
                    sb.append(v%10);
                }
                carry=v/10;
                pos++;
            }
            if(carry>0){
                sb.append(carry);
            }
            carry=0;
            step++;
        }
        return sb.reverse().toString();
    }
public static void main(String argv[]){
    String s1="99";
    String s2="99";
    String res=new Solution().multiply(s1,s2);
    System.out.println(res);
}
public void print(Object o){
    System.out.println(o);
}
}