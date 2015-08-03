# coding=utf-8
class Solution:
    # @param A, a list of integers
    # @return an integer
    # ���б�ֽ�, һ�����Ե���ķ�Χ����һ������, ������������ܵ������Զ��������һ���ɵ���ķ�Χ,���Կ����Ͻ�˹�����㷨?
    def jump(self, A):
        length = len(A)
        if length<=1:
            return 0
        dist = 0# ��Զ�����±�
        step = 0# ���߲���
        lastbreak = 0# ��һ�ڿ��Ե������Զλ���±�
        for i in range(length-1):
            dist = max(dist, A[i]+i)# ��ǰλ��iʱ,�������ߵ�����Զλ�õ��±�
            if i == lastbreak:
            # �����һ���Ѿ�����
                step += 1
                lastbreak = dist
        return step
    