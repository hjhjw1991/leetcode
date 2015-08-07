# coding=utf-8
# 从公主所在的位置起，位于某个位置时所需要的最低血量=min(它右边最低血量，它下边最低血量) 减去当前扣血，同时注意如果所需血量最低为0
#可以观察到，任意时候我们只需要知道右边一个和下边一个的最低血量即可
#由此得到启发，可以从右往左从下往上扫描，这就是本题动态规划的解法
#注意只有一行的时候，需要特殊处理一下
class Solution:
    # @param {integer[][]} dungeon
    # @return {integer}
    def calculateMinimumHP(self, dungeon):
        if not dungeon:
            return 1
        row=len(dungeon)
        col=len(dungeon[0])
        below=[0]*(col+1)
        cur=[0]*col
        for c in xrange(col-1,-1,-1):
            below[c]=max(below[c+1]-dungeon[row-1][c],0)
        if row<2:
            return below[0]+1 if below[0]>0 else 1
        for r in xrange(row-2,-1,-1):
            for c in xrange(col-1,-1,-1):
                if c==col-1:
                    cur[c]=max(below[c]-dungeon[r][c],0)
                else:
                    cur[c]=max(min(below[c],cur[c+1])-dungeon[r][c],0)
            print below,cur
            below=cur
        return cur[0]+1 if cur[0]>0 else 1

so=Solution()
s=[[0,0,0],[1,1,-1]]
print so.calculateMinimumHP(s)
s=[[2,1],[1,-1]]
print so.calculateMinimumHP(s)
s=[[-2,-3,3],
[-5,-10,1],
[10,30,-5]]
print so.calculateMinimumHP(s)