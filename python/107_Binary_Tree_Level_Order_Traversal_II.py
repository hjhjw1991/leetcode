# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrderBottom(self, root):
        if not root:
            return []
        queue=[root]
        res=[]
        while queue:
            nextLevel=[]
            curLine=[]
            for node in queue:
                curLine.append(node.val)
                if node.left:
                    nextLevel.append(node.left)
                if node.right:
                    nextLevel.append(node.right)
            queue=nextLevel
            res.append(curLine)
        return res[::-1]
                