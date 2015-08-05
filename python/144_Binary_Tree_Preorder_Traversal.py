# coding=utf-8
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def preorderTraversal(self, root):
        if not root:
            return []
        queue=[root]
        vals=[root.val]
        cur=root
        if cur.left:
            cur=cur.left
            while cur:
                vals.append(cur.val)
                queue.append(cur)
                cur=cur.left
        while queue:
            cur=queue.pop()
            if cur.right:
                cur=cur.right
                while cur:
                    vals.append(cur.val)
                    queue.append(cur)
                    cur=cur.left
        return vals
root=TreeNode(1)
root.right=TreeNode(2)
root.right.left=TreeNode(3)
so=Solution()
print so.preorderTraversal(root)