# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @param {integer} sum
    # @return {integer[][]}
    def pathSum(self, root, sum):
        if root is None:
            return []
        path = []
        self.search(root, sum, [], path)
        return path
  
    def search(self, node, sum, curpath, path):
        if node.left is None and node.right is None and node.val==sum:
            curpath.append(node.val)
            path.append(curpath)
        if node.left is not None:
            self.search(node.left, sum-node.val, curpath+[node.val], path)
        if node.right is not None:
            self.search(node.right, sum-node.val, curpath+[node.val], path)