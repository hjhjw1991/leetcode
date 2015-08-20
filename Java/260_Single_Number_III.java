public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length<3){
            return nums;
        }
        int[] a={0,0};
        int b=0;
        //suppose x and y are single numbers
        //after xor all numbers, the result will be x^y
        //and x^y^y=x, so we just need to find x(or y)
        //then y=x^y^x
        //to find x, we just need the most significant bit or lowest bit of x^y, suppose it's z and comes from x. 
        //we know that y is not in those numbers that the bit of z is 1
        //we xor all numbers with z, so we find x
        for(int num:nums){
            b=b^num;
        }
        int lowest = b&~(b-1);
        for(int num:nums){
            if((num & lowest)!=0){
                a[0]^=num;
            }
        }
        a[1]^=b^a[0];
        return a;
    }
}