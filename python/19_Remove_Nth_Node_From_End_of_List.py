# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} n
    # @return {ListNode}
    def removeNthFromEnd(self, head, n):
        post=head
        cur=head
        while n>0:
            post=post.__next__
            n-=1
        if not post:
            return cur.__next__
        while post.__next__:
            post=post.__next__
            cur=cur.__next__
        cur.next=cur.next.__next__
        return head