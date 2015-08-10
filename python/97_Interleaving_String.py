# coding=utf-8
import unittest
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def solve(self, (s1, s2, s3)):
        return self.isInterleave(s1, s2, s3)

    def isInterleave(self, s1, s2, s3):
        if not s1 or not s2:
            if (not s1 and s2==s3) or (not s2 and s1==s3):
                return True
            else:
                return False
        l1=len(s1)
        l2=len(s2)
        if len(s3)!=l1+l2:
            return False
        dp=[[False for j in range(l2+1)] for i in range(l1+1)]#表示s1的前i个字符和s2的前j个字符能否穿插组成s3的前i+j个字符
        for i in xrange(1,l1+1):
            dp[i][0]= (s1[:i]==s3[:i])#初始化，只有一个串为前缀
        for i in xrange(1,l2+1):
            dp[0][i]= (s2[:i]==s3[:i])#初始化，只有一个串为前缀
        for i in xrange(1,l1+1):
            for j in xrange(1,l2+1):
                dp[i][j]=(dp[i][j-1] and s2[j-1]==s3[i+j-1]) or (dp[i-1][j] and s1[i-1]==s3[i+j-1])#递推公式，如果有新的字符，则必属于两个串之一
        return dp[l1][l2]
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[
        #("a", "b", "ab"),# True
        #("aabcc", "dbbca", "aadbbcbcac"),# True
        #("aabcc", "dbbca", "aadbbbaccc"),# False
        ("db", "b", "cbb"),
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

