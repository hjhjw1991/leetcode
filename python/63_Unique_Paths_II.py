class Solution:
    # @param {integer[][]} obstacleGrid
    # @return {integer}
    def uniquePathsWithObstacles(self, obstacleGrid):
        if not obstacleGrid:
            return 0
        row=len(obstacleGrid)
        col=len(obstacleGrid[0])
        cur=[1]*col
        below=[1]*(col+1)
        for c in xrange(col-1,-1,-1):
            if obstacleGrid[row-1][c]==1:
                below[c]=0
            else:
                below[c]=below[c+1]
        if row==1:
            return below[0]
        for r in xrange(row-2,-1,-1):
            for c in xrange(col-1,-1,-1):
                if obstacleGrid[r][c]==1:
                    cur[c]=0
                elif c==col-1:
                    cur[c]=below[c]
                else:
                    cur[c]=below[c]+cur[c+1]
            below=cur
        return cur[0]