# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isValidBST(self, root):
        if not root:
            return True
        queue=[]
        while root:
            #if root.left and root.left.val>root.val:
            #    return False
            queue.append(root)
            root=root.left
        pre=node=queue.pop()
        if node.right:
            node=node.right
            while node:
                queue.append(node)
                node=node.left
        while queue:
            node=queue.pop()
            if pre.val>=node.val:
                return False
            pre=node
            if node.right:
                node=node.right
                while node:
                    queue.append(node)
                    node=node.left
        return True