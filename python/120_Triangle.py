# coding=utf-8
# #problem number 120
class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if triangle is None or len(triangle)==0:
            return 0
        res=triangle[-1]
        for cur in range(2,len(triangle)+1):
            lastbutone=triangle[-cur]
            now=[]
            for i in range(len(lastbutone)):
                now.append(lastbutone[i]+min(res[i],res[i+1]))
            res=now
        return res[0]
        
triang=[
    [2],
    [3,4],
    [6,5,7],
    [4,1,8,3]]
s = Solution()
print((s.minimumTotal(triang)))