public class Solution {
    public int findPeakElement(int[] num) {
        if(num==null||num.length<=0)return 0;
        int i=0;
        for(i=0;i<num.length-1;i++){
            if(num[i]<num[i+1])continue;
            else
            break;
        }
        return i;
    }
}