class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def searchInsert(self, nums, target):
        if not nums:
            return 0
        if target<=nums[0]:
            return 0
        elif target>nums[-1]:
            return len(nums)
        else:
            left=0
            right=len(nums)
            while left<right:
                mid=(left+right)/2
                if target==nums[mid]:
                    return mid
                elif target<nums[mid]:
                    right=mid-1
                else:
                    left=mid+1
            return left if nums[left]>=target else left+1