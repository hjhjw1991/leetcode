# coding=utf-8
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, x):
        return self.nextPermutation(x)

    def nextPermutation(self, nums):
        if not nums or len(nums)==1:
            return
        length=len(nums)
        left=length-2
        while left>=0:
            if nums[left]<nums[left+1]:
                break
            left-=1
        if left>=0:
            right=length-1
            while nums[left]>=nums[right]:
                right-=1
            nums[left],nums[right]=nums[right],nums[left]
            left+=1
        else:
            left=0
        right=length-1
        while left<right:
            nums[left],nums[right]=nums[right],nums[left]
            left+=1
            right-=1
        print nums
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[
        [1,2,3],
        [3,2,1],
        [1,1,5],
        [1,2,2,3,5,7,7,6,6,5,5,1,2],
        [1,2,2,3,5,7,7,6,6,5,5,2,1],
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

