# coding=utf-8
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, nums):
        return self.partition(nums)
        
    def partition(self, s):
        if not s or len(s)==1:
            return [[s]]
        pre=[]
        res=[]
        for i in xrange(1,len(s)+1):
            if self.isPalindrome(s[:i]):
                pre.append(i)
        for x in pre:
            for p in self.partition(s[x:]):
                res.append([s[:x]]+p) if p[0] else res.append([s[:x]])
        return res
        
    def isPalindrome(self,st):
        return st[::-1]==st
        
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[
    #   "a",
    #   "aaaaa",
    #   "ab",
    #   "abbab",
        "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi",
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            res=self.s.solve(case)
            print "result: ",res
            print len(res)
            # if assert is needed
            
unittest.main()

