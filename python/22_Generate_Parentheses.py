# coding=utf-8
import unittest
class Solution:
    def solve(self, nums):
        return self.generateParenthesis(nums)
    
    # my version. brute one
    def generateParenthesis(self, n):
        if n<1:
            return [""]
        if n==1:
            return ["()"]
        parenthese=[]
        left,right="(",")"
        for i in range(2*n):
            inner=self.generateParenthesis(i>>1)
            outer=self.generateParenthesis(n-1-(i>>1))
            for l in inner:
                for r in outer:
                    parenthese.append(left+l+right+r)
        return list(set(parenthese))
        
    # other solutions
    def generateParenthesis(self, n, open=0):
        if n > 0 <= open:
            return ['(' + p for p in self.generateParenthesis(n-1, open+1)] + \
                   [')' + p for p in self.generateParenthesis(n, open-1)]
        return [')' * open] * (not n)
        
    def generateParenthesis(self, n):
        def generate(p, left, right, parens=[]):
            if left:         generate(p + '(', left-1, right)
            if right > left: generate(p + ')', left, right-1)
            if not right:    parens += p,
            return parens
        return generate('', n, n)

    def generateParenthesis(self, n):
        def generate(p, left, right):
            if right >= left >= 0:
                if not right:
                    yield p
                for q in generate(p + '(', left-1, right): yield q
                for q in generate(p + ')', left, right-1): yield q
        return list(generate('', n, n))
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        self.cases=[
                0,
                1,
                2,
                3,
                4,
                5,
                    ]
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print(("testcase: ", case))
            print(("result: ",self.s.solve(case)))
            # if assert is needed
            
unittest.main()

