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
        queue=[]
        res=[]
        while root:
            queue.append(root)
            root=root.left
        while queue:
            cur=queue.pop()
            res.append(cur.val)
            if cur.right:
                cur=cur.right
                while cur:
                    queue.append(cur)
                    cur=cur.left
        return res