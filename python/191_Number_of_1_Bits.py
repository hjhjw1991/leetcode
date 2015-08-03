class Solution:
    # @param n, an integer
    # @return an integer
    def hammingWeight(self, n):
        res=0
        while n>0:
            res=res+n%2
            n=n>>1
        return res