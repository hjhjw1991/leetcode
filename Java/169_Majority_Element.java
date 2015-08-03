// another idea is using bit manipulation
public class Solution {
    public int majorityElement(int[] num) {
        if(num.length<=0)return 0;
        Arrays.sort(num);
		return num[num.length/2];
    }
}