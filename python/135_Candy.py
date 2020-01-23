# coding=utf-8
import unittest

class Solution:
    def solve(self, nums):
        return self.candy(nums)

    # @param {integer[]} ratings
    # @return {integer}
    def candy(self, ratings):
        length=len(ratings)
        if length<2:
            return length
        candies=[1]*length
        for i in range(1,length):
            if ratings[i]>ratings[i-1]:
                candies[i] = candies[i-1]+1
        for i in range(length-2,-1,-1):
            candies[i]=max(candies[i+1]+1,candies[i]) if ratings[i]>ratings[i+1] else candies[i]
        return sum(candies)
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        case=[
        [1,2,2],#4
        [1,2,1,3],#6
        [2,1],#3
        [3,2,1,2,2,1],#11
        [8,6,6,4,3,9,7,1],#15
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print(("testcase: ", case))
            res=self.s.solve(case)
            print(("result: ",res))
            # if assert is needed
            
unittest.main()

