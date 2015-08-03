class Solution:
    # @param {integer[]} nums
    # @param {integer} val
    # @return {integer}
    def removeElement(self, nums, val):
        if not nums:
            return 0
        j=0
        while j<len(nums) and nums[j]==val:
            j+=1
        for i in range(j+1,len(nums)):
            if nums[i]==val:
                nums[i]=nums[j]
                j+=1
        del nums[:j]
        return len(nums)