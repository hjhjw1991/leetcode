public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 问题不难，细节处理三个地方：
        // 1 余数及其对应位置记录下来，当出现重复的余数时，得当上一个该余数的位置即为循环节开始。注意+1问题
        // 2 符号问题，需要额外记录符号，并转换成正数处理，最后根据符号决定是否输出-号。这个问题会引发问题3
        // 3 溢出问题。在进行正负号转换的时候，边界值会发生异变，要小心处理溢出造成的计算错误。我这里是直接转换成long再取绝对值
        if(denominator==0)return "0";
        int flag=(numerator>=0&&denominator>0?1:numerator<=0&&denominator<0?1:-1);//positive or negative
        long numer = Math.abs((long)numerator);
        long denomin = Math.abs((long)denominator);//overflow!!!
        StringBuffer sb = new StringBuffer();
        HashMap<Long, Integer> remain = new HashMap<Long, Integer>();
        long res = numer/denomin;
        long rem = numer%denomin;
        sb.append(String.valueOf(res));
        if(rem!=0){
            sb.append(".");
            int dig=sb.length();
            remain.put(rem, dig);// 当前位置dig指向小数点后一位，该位置的余数为rem
            while(rem!=0){
                res = rem*10;
                sb.append(String.valueOf(res/denomin));// 计算当前位置商并填入该位置
                rem = res%denomin;// 计算下一位的余数
                if(remain.containsKey(rem)){// 如果下一位的余数出现过，说明该位置的商也被填过了，取到该余数所在的索引，即填商的位置
                    sb.insert((int)remain.get(rem), '(');
                    sb.append(")");
                    break;
                }
                remain.put(rem, ++dig);// 将下一位余数及其对应位置加入map
            }
        }
        if(flag<0)sb.insert(0, '-');
        return sb.toString();
    }
}