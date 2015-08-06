class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maxSubArray(self, nums):
        length=len(nums)
        if length<1:
            return
        maxx=res=nums[0]
        for i in xrange(1,length):
            maxx=max(maxx+nums[i],nums[i])
            res=max(res,maxx)
        return res