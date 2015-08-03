class Solution:
    # @param {integer} n
    # @return {integer}
    def climbStairs(self, n):
        if n==1:
            return 1
        elif n==2:
            return 2
        else:
            a,b,i=1,2,3
            while i<=n:
                a,b,i=b,a+b,i+1
            return b