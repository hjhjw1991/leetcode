class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maxProduct(self, nums):
        length=len(nums)
        if length<1:
            return
        elif length==1:
            return nums[0]
        minn=maxx=res=nums[0]
        for i in xrange(1,length):
            tmp=maxx
            maxx=max(minn*nums[i],maxx*nums[i],nums[i])
            minn=min(minn*nums[i],tmp*nums[i],nums[i])
            res=max(res,maxx)
        return res