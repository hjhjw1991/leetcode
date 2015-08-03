# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {void} Do not return anything, modify root in-place instead.
    def flatten(self, root):
        if not root:
            return
        self.flatten(root.right)
        if not root.left:
            return
        self.flatten(root.left)
        tail = root.left
        while tail.right:
            tail = tail.right
        tail.right = root.right
        root.right = root.left
        root.left = None