class Solution:
    # @param {integer[]} height
    # @return {integer}
    def maxArea(self, height):
        res,left,right=0,0,len(height)-1
        if right<1:
            return 0
        while left<right:
            res=max(res,(right-left)*min(height[right],height[left]))
            if height[right]>height[left]:
                left=left+1
            elif height[right]<height[left]:
                right=right-1
            else:
                left,right=left+1,right-1
        return res