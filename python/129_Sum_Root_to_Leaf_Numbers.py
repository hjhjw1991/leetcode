# coding=utf-8
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, nums):
        return self.sumNumbers(nums)
        
    def sumNumbers(self, root):
        if not root:
            return 0
        parent=0
        queue=[]
        res=[]
        cur=root
        while cur:
            parent=parent*10+cur.val
            queue.append(cur)
            queue.append(0)
            cur=cur.left
        while queue:
            isVisit=queue.pop()
            cur=queue.pop()
            if not isVisit and cur.right:
                queue.append(cur)
                queue.append(1)
                cur=cur.right
                parent=parent*10+cur.val
                queue.append(cur)
                queue.append(0)
                while cur.left:
                    cur=cur.left
                    parent=parent*10+cur.val
                    queue.append(cur)
                    queue.append(0)
            else:
                if not cur.right and not cur.left:
                    res.append(parent)
                parent=parent/10
        return sum(res)
        
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        root=TreeNode(1)
        root.left=TreeNode(2)
        root.left.left=TreeNode(4)
        root.left.right=TreeNode(5)
       #root.left.right.right=TreeNode(8)
        root.right=TreeNode(3)
       #root.right.left=TreeNode(6)
       #root.right.right=TreeNode(7)
        case=[
        root,
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            print "result: ",self.s.solve(case)
            # if assert is needed
            
unittest.main()

