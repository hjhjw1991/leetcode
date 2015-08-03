public class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1)
            return 0;
        int max=0;
        int left=0,right=height.length-1;
        while(left<right){
            max=Math.max(max,(right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right]){
                left++;
            }else if(height[left]>height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return max;
    }
    
    public static void main(String[] args){
        Solution sl=new Solution();
        int[][] testdata={
            {
                1,2,3,4,5,4,5,6
            },
            {
                2,3,2,1
            }
        };
        for(int[] s:testdata){
            System.out.println(sl.maxArea(s));
        }
    }
}