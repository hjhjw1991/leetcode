public class Solution {
    public int findMin(int[] num) {
        int L = 0;
        while(L<num.length-1&&num[L]<=num[L+1])L++;
        if(L==num.length-1)L=-1;
        return num[L+1];
    }
}