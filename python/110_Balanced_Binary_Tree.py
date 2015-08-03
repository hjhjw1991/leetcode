# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isBalanced(self, root):
        if root is None or (root.left is None and root.right is None):
            return True
        if self.isBalanced(root.left) and self.isBalanced(root.right) and -1 <= (self.height(root.left) - self.height(root.right)) <= 1:
            return True
        return False
        
    def height(self, node):
        if node is None:
            return 0
        return 1+max(self.height(node.left),self.height(node.right))