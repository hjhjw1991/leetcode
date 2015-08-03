# variable left is not necessary
# just let right=nums[0], and then let right=max(middle,right)+nums[i]
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        if not nums or len(nums)<1:
            return 0
        length=len(nums)
        if length==1:
            return nums[0]
        if length==2:
            return max(nums)
        left,middle,right,i=nums[0],nums[1],nums[0]+nums[2],3
        while i<length:
            left,middle,right,i=middle,right,max(left,middle)+nums[i],i+1
        return max(left,middle,right)