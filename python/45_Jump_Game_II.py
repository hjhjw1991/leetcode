# coding=utf-8
class Solution:
    # @param A, a list of integers
    # @return an integer
    # 将列表分节, 一步可以到达的范围看做一个整体, 从这个整体中能到达的最远距离是下一步可到达的范围,可以看做迪杰斯特拉算法?
    def jump(self, A):
        length = len(A)
        if length<=1:
            return 0
        dist = 0# 最远距离下标
        step = 0# 已走步数
        lastbreak = 0# 上一节可以到达的最远位置下标
        for i in range(length-1):
            dist = max(dist, A[i]+i)# 当前位置i时,整体能走到的最远位置的下标
            if i == lastbreak:
            # 如果上一节已经走完
                step += 1
                lastbreak = dist
        return step
    