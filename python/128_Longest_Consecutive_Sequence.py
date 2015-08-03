class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def longestConsecutive(self, nums):
        if not nums or len(nums)<2:
            return len(nums)
        p,max={},1
        for num in nums:
            p[num]=1
        for num in nums:
            p[num]=0
            k,cnt=num+1,1
            while p.get(k,0)!=0:
                p[k]=0
                cnt,k=cnt+1,k+1
            k=num-1
            while p.get(k,0)!=0:
                p[k]=0
                cnt,k=cnt+1,k-1
            max=cnt if max<cnt else max
        return max