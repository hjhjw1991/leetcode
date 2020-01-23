# coding=utf-8
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.vals=[]
        if root:
            stack=[root]
            while root.left:
                stack.append(root.left)
                root=root.left
            while stack:
                root=stack.pop()
                self.vals.append(root.val)
                if root.right:
                    root=root.right
                    stack.append(root)
                    while root.left:
                        stack.append(root.left)
                        root=root.left

    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return len(self.vals)>0

    # @return an integer, the next smallest number
    def __next__(self):
        if self.hasNext():
            return self.vals.pop(0)
    
root=TreeNode(3)
root.left=TreeNode(1)
root.right=TreeNode(5)
root.left.right=TreeNode(2)
root.right.left=TreeNode(4)
root.left.left=TreeNode(0)
root.right.right=TreeNode(6)
i, v = BSTIterator(root), []
while i.hasNext(): v.append(next(i));print(v)