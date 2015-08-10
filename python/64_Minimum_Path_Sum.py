class Solution:
    # @param {integer[][]} grid
    # @return {integer}
    def minPathSum(self, grid):
        if not grid:
            return 0
        row=len(grid)
        col=len(grid[0])
        below=[0]*(col+1)
        cur=[0]*col
        for i in range(col-1,-1,-1):
            below[i]=below[i+1]+grid[row-1][i]
        if row==1:
            return below[0]
        for r in range(row-2,-1,-1):
            for c in range(col-1,-1,-1):
                if c==col-1:
                    cur[c]=below[c]+grid[r][c]
                else:
                    cur[c]=min(below[c],cur[c+1])+grid[r][c]
            below=cur
        return cur[0]