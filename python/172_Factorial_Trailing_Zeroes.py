class Solution:
    # @param {integer} n
    # @return {integer}
    def trailingZeroes(self, n):
        ans=0
        while n>0:
            ans=ans+n/5
            n=n/5
        return ans