# coding=utf-8
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
        
class Solution:
    def swapPairs(self, head):
        if not head or not head.next:
            return head
        pre=head
        post=head.next
        head=post
        pre.next=post.next
        post.next=pre
        while pre.next:
            cur=pre.next
            post=cur.next
            if not post:
                break
            cur.next=post.next
            pre.next=post
            post.next=cur
            pre=cur
        return head
        
def buildList(vals):
    if not vals:
        return
    head=dummy=ListNode(vals[0])
    for val in vals:
        head.next=ListNode(val)
        head=head.next
    return dummy.next
    
def printList(head):
    if not head:
        return
    while head.next:
        print(head.val,"->", end=' ')
        head=head.next
    print(head.val)
        
so=Solution()
head=buildList([1,2,3,4,5,6])
printList(so.swapPairs(head))
head=buildList([1])
printList(so.swapPairs(head))
head=buildList([1,2,3,4,5])
printList(so.swapPairs(head))