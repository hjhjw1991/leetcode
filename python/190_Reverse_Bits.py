class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        res=0
        scale=2**31
        while n>0:
            res,scale,n=res+n%2*scale,scale/2,n/2
        return res