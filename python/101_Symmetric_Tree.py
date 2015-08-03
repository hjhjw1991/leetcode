# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isSymmetric(self, root):
        if not root:
            return True
        if not root.left or not root.right:
            if root.left or root.right:
                return False
            return True
        leftqueue=[root.left]
        rightqueue=[root.right]
        while leftqueue and rightqueue:
            nextleft=[]
            nextright=[]
            if len(leftqueue)!=len(rightqueue):
                return False
            for i in range(len(leftqueue)):
                if leftqueue[i].val!=rightqueue[i].val:
                    return False
                if leftqueue[i].left and rightqueue[i].right:
                    nextleft.append(leftqueue[i].left)
                    nextright.append(rightqueue[i].right)
                elif leftqueue[i].left or rightqueue[i].right:
                    return False
                if leftqueue[i].right and rightqueue[i].left:
                    nextleft.append(leftqueue[i].right)
                    nextright.append(rightqueue[i].left)
                elif leftqueue[i].right or rightqueue[i].left:
                    return False
            leftqueue=nextleft
            rightqueue=nextright
        if leftqueue or rightqueue:
            return False
        return True
