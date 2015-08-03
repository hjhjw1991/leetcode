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
            post=post.next
            n-=1
        if not post:
            return cur.next
        while post.next:
            post=post.next
            cur=cur.next
        cur.next=cur.next.next
        return head