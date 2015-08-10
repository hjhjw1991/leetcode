class Solution:
    # @param {integer} m
    # @param {integer} n
    # @return {integer}
    def uniquePaths(self, m, n):
        if not m or not n:
            return 0
        if m==1 or n==1:
            return 1
        below=[1]*n
        cur=[1]*n
        for r in xrange(m-2,-1,-1):
            for c in xrange(n-1,-1,-1):
                if c==n-1:
                    cur[c]=1
                else:
                    cur[c]=below[c]+cur[c+1]
            below=cur
        return cur[0]