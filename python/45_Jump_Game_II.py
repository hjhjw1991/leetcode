# coding=utf-8
class Solution:
    # @param A, a list of integers
    # @return an integer
    # 给定一个非负整数数组，你最初位于数组的第一个位置。

    # 数组中的每个元素代表你在该位置可以跳跃的最大长度。

    # 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

    # 来源：力扣（LeetCode）
    # 链接：https://leetcode-cn.com/problems/jump-game-ii
    # 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    def jump(self, A):
        length = len(A)
        if length<=1:
            return 0
        dist = 0# 记录当前位置能跳到的最远位置
        step = 0# 记录一共需要多少次跳跃, 一开始是0次
        lastbreak = 0# 记录上次能跳到的最远位置
        for i in range(length-1):
            # 遍历数组, 在上次能跳到的最远位置之前, 所有位置可以跳到的最远位置, 作为下一次的界限
            # 跳跃到最后位置所需要的最少步数==在最少步数内能跳到的最远范围包含最后一位
            dist = max(dist, A[i]+i)
            if i == lastbreak:
            # 当扫描已经到达了本次(step步)能到达的最远位置, 则步数+1, 边界更新为到此为止能到达的最远位置
                step += 1
                lastbreak = dist
        return step
    