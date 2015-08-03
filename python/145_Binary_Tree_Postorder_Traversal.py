#coding=utf-8
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        stack=[]
        res=[]
        visit=root
        while visit is not None:
            stack.append(visit)
            stack.append(0)
            # 压入0表示其右孩子没有被访问过
            visit=visit.left
        while len(stack)>0:
            if stack[-2].right is None or stack[-1]==1:
                # 栈顶没有右孩子或者其右孩子已经被访问
                res.append(stack[-2].val)
                # 访问该节点
                stack=stack[0:-2]
            else:
                stack[-1]=1
                visit = stack[-2].right
                while visit is not None:
                    # 从右孩子往左下走到最后，并把沿途节点都入栈
                    stack.append(visit)
                    stack.append(0)
                    visit=visit.left
        return res