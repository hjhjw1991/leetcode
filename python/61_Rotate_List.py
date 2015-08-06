# coding=utf-8
# 61
import unittest
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def solve(self, head, k):
        return self.rotateRight(head, k)
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def rotateRight(self, head, k):
        if not head or k == 0:
            return head
        runner=cur=head
        length=0
        while runner:
            runner=runner.next
            length+=1
        runner=head
        k=k%length
        if k==0:
            return head
        while k>0:
            runner=runner.next
            k-=1
        while runner and runner.next:
            cur=cur.next
            runner=runner.next
        res=cur.next
        runner.next=head
        cur.next=None
        return res
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[]
        num=0
        head=ListNode(num)
        for i in range(num-1,-1,-1):
            tmp=ListNode(i)
            tmp.next=head
            head=tmp
        case.append(head)
        while head:
            print head.val,
            head=head.next
        print 
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            print "result: ",self.s.solve(case,1)
            # if assert is needed
            
unittest.main()

