// Boyer-Moore algorithm
public class Solution {
    public int majorityElement(int[] num) {
        if(num.length<=0)return 0;
        int a=0,ca=0;
        for(int x:num){
            if(a==x||ca==0){
                a=x;
                ca++;
            }else{
                ca--;
            }
        }
        ca=0;
        for(int x:num){
            if(a==x)ca++;
        }
        if(ca>num.length/2)return a;
        return 0;
    }
}