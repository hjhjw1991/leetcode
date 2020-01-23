# coding=utf-8
# C is quite fast
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, nums):
        return self.minCut(nums)
        
    def minCut(self, s):
        if not s or len(s)==1 or s[::-1]==s:
            return 0
        length=len(s)
        for i in range(1, length):
            if s[:i] == s[:i][::-1] and s[i:] == s[i:][::-1]:
                return 1
        isPalindrome=[[False] * (j + 1) for j in range(length)]
        dp=list(range(length))+[-1]
        for r in range(length):
            for m in range(r,-1,-1):
                if s[m]==s[r] and (r-m<2 or isPalindrome[r-1][m+1]):
                    isPalindrome[r][m]=True
                    dp[r]=min(dp[r], dp[m-1]+1)
        return dp[length-1]
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        case=[
        #"fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi",
        #"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"
        "abs",
        #"aaaaa",
        "cabababcbc",
        #"abcdefghijklmnopqrssrponmlkjihgfedcba",
        
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

