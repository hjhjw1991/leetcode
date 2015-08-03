# equals to find all most right node in breadth first search(level order traversal)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def rightSideView(self, root):
        if not root:
            return []
        queue=[root]
        res=[]
        while queue:
            res.append(queue[-1].val)
            cur=[]
            for node in queue:
                if node.left:
                    cur.append(node.left)
                if node.right:
                    cur.append(node.right)
            queue=cur
        return res