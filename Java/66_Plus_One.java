public class Solution {
    public int[] plusOne(int[] digits) {
        // Easy题，没坑，注意进位
        if(digits==null||digits.length==0)return digits;
        int len=digits.length;
        int i=len-2, c=(digits[len-1]+1)/10;
        digits[len-1] = (digits[len-1]+1)%10;
        while(c>0&&i>=0){
            digits[i]+=c;
            c=digits[i]/10;
            digits[i]=digits[i]%10;
            i--;
        }
        if(c>0){
            int[] news = new int[len+1];
            news[0]=c;
            for(i=0;i<len;i++){
                news[i+1]=digits[i];
            }
            return news;
        }
        return digits;
    }
}