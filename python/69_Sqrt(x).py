# coding=utf-8
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, x):
        return self.mySqrt(x)

    def mySqrt(self, x):
        if x<=0:
            return 0
        if x<4:
            return 1
        left=1
        right=2
        while right*right<x:
            left=right
            right=right*right
        while left<=right:#注意等于符号
            mid=(left+right)/2
            if mid*mid==x:
                return mid
            elif mid*mid>x:
                right=mid-1#移位避免死循环
            else:
                left=mid+1#移位避免死循环
        return right#注意二叉查找最终状态
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[
        #-1,
        #4,
        #169,
        #100,
        #10,
        #16,
        #25,
        #33,
        48,
        49,
        50,
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            res=self.s.solve(case)
            print "result: ",res
            # if assert is needed
            
unittest.main()

