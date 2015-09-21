import java.util.*;
public class Solution {
    
    HashMap<Integer, String> map = new HashMap<Integer, String>(){
        {
            put(0, "Zero");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
            put(100, "Hundred");
            put(1000, "Thousand");
            put(1000000, "Million");
            put(1000000000, "Billion");
        }
    };
    public String numberToWords(int num) {
        if(num<0)return "";
        else if(num<=20)return under20(num);
        else return over20(num);
    }
    
    public String under20(int num){
        return map.get(num);
    }
    
    public String over20(int num){
        ArrayList<String> al = new ArrayList<>();
        int sec = 0;
        int cur = 0;
        while(num!=0){
            cur = num % 1000;
            if(num>0&&sec>=3&&sec<=9&&cur>0){
                al.add(map.get((int)Math.pow(10, sec)));// should do it first, for case like 1000, 2000000, and so on
            }
            num = num/1000;// put it after the above if.
            if(cur/10 % 10<2&&cur%100>0){// notice that when cur is 00 or 000
                al.add(map.get(cur%100));
            }else if(cur/10 % 10>=2){
                if(cur%10>0)al.add(map.get(cur%10));// notice that when cur is 00 or 000
                al.add(map.get(cur/10%10*10));
            }
            if(cur/100>=1){
                al.add(map.get(100));
                al.add(map.get(cur/100));
            }
            sec+=3;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(al.get(al.size()-1));
        for(int i=al.size()-2;i>=0;i--){
            sb.append(" ");
            sb.append(al.get(i));
        }
        return sb.toString();
    }
}