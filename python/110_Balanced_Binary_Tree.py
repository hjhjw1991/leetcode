# coding=utf-8
# #problem number 110
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
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
        
s=Solution()
root1=TreeNode(2)
root1.left=TreeNode(1)
root1.right=TreeNode(4)
root1.right.left=TreeNode(3)
root1.right.right=TreeNode(6)
root1.right.right.left=TreeNode(5)
print((s.isBalanced(root1)))
root2=TreeNode(72)
root2.left=TreeNode(54)
root2.left.right=TreeNode(67)
root2.right=TreeNode(76)
print((s.isBalanced(root2)))