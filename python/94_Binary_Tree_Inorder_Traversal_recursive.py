# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def inorderTraversal(self, root):
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        left=self.inorderTraversal(root.left)
        right=self.inorderTraversal(root.right)
        return left+[root.val]+right