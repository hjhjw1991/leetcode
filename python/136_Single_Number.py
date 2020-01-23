# coding=utf-8
import unittest
class Solution:
    def solve(self, nums):
        return self.singleNumber(nums)
        
    def singleNumber(self, nums):
        res=0
        for i in nums:
            res=res^i
        return res
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        case=[
        [2,0,0,0],
        [1,2,2,2,0,0,0],
        [3,2,2,3,3,2,5],
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print(("testcase: ", case))
            print(("result: ",self.s.solve(case)))
            # if assert is needed
            
unittest.main()

