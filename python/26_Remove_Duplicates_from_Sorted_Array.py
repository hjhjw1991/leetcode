class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        last=nums[0]
        m=1
        for i in range(1, len(nums)):
            if nums[i]!=last:
                last=nums[i]
                nums[m]=nums[i]
                m+=1
        del nums[m:]
        return len(nums)