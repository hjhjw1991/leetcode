# coding=utf-8
import unittest
class Solution:
    def solve(self, nums):
        return self.canJump(nums)
        
    def canJump(self, nums):
        if not nums:
            return True
        length=len(nums)
        cur=0
        forward=nums[0]
        while forward<length-1 and forward+nums[forward]<length-1:
            nextpos=forward+nums[forward]
            for i in range(cur,forward):
                if i+nums[i]>nextpos:
                    nextpos=i+nums[i]
            if forward==nextpos:
                return False
            cur=forward
            forward=nextpos
        return True
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[[2,3,0,0],[1,2,2,0,0],[3,2,1,0,5],[0],[1],[1,0],[1,5,0,1,0]]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            print "result: ",self.s.solve(case)
            # if assert is needed
            
unittest.main()

