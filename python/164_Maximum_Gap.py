class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maximumGap(self,nums):
        nums = list(set(nums))
        n = len(nums)
        if n < 2:
            return 0
    
        min_val, max_val = min(nums), max(nums)
        interval = (max_val - min_val) / n
        container = [None] * n
        for i in range(0, n):
            container[i] = set()
    
        for val in nums:
            idx = min((val - min_val) / interval, n - 1)
            container[idx].add(val)
    
        res = last = 0
        for i in range(0, n):
            if len(container[i]):
                res = max(res, min(container[i]) - max(container[last]))
                last = i
        return res