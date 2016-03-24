public class Solution {
    public int[] countBits(int num) {
        if(num<=0)return new int[]{0};
        int[] ret = new int[num+1];
        ret[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2==1){
                ret[i]=ret[i-1]+1;// odd number can only have 1 more '1' than the last even number
            }else{
                ret[i] = ret[i-1] - ret[((i-1)^i)>>1]+1;
                // i can be represented as xxxx10..0, where x is not cared, and 1 is the most right 1.
                // so fun(i) = fun(xxxx10..0) = fun(xxxx01..1)-fun(000001..1)+1
                // meanwhile, 000001..1 = (xxxx01..1 XOR xxxx10..0)>>1
            }
        }
        return ret;
    }
}