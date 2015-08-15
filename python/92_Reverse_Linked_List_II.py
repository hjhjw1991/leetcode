# coding=utf-8
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    # @param {ListNode} head
    # @param {integer} m
    # @param {integer} n
    # @return {ListNode}
    def reverseBetween(self, head, m, n):
        if not m or not n or m>n:
            return head
        dummy=ListNode(0)
        dummy.next=head
        cur=dummy.next
        i=1
        start=dummy
        while i<m and cur:
            start=cur
            cur=cur.next
            i+=1
        if cur:
            stop=cur
            runner=cur.next
            while i<n and runner:
                p=runner.next
                runner.next=cur
                cur=runner
                runner=p
                i+=1
            stop.next=runner
            start.next=cur
        return dummy.next
        
def printList(head):
    if not head:
        print "None"
    while head.next:
        print head.val,"->",
        head=head.next
    print head.val
    
so=Solution()
h=head=ListNode(1)
for i in range(2,6):
    h.next=ListNode(i)
    h=h.next
head=so.reverseBetween(head, -1, 3)
printList(head)
head=so.reverseBetween(head, 2, 2)
printList(head)