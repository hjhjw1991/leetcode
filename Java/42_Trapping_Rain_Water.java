public class Solution {
    // 算法：
    // 左右两边作为边界，其间的低于边界的地方会被水填充
    // 高于边界的地方会成为新的边界
    public int trap(int[] height) {
        if(height==null)return 0;
        int len = height.length;
        if(len<=2)return 0;
        int left = 0, right = len-1, cur;
        int res=0, lv = 0, rv = 0;
        while(left<right){
            lv = height[left];
            rv = height[right];
            if(lv<rv){//找到更低的边界
                while(left<right&&height[left]<=lv){//填充低于边界的地方
                    res+=lv-height[left];
                    left++;
                }
            }else{//找到更低的边界
                while(right>left&&height[right]<=rv){//填充低于边界的地方
                    res+=rv-height[right];
                    right--;
                }
            }
        }
        return res;
    }
}