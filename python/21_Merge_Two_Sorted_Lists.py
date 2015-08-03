# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def mergeTwoLists(self, l1, l2):
        if not l1:
            return l2
        elif not l2:
            return l1
        p=ListNode(0)
        head=p
        while l1 and l2:
            if l1.val>l2.val:
                p.next=l2
                l2=l2.next
            else:
                p.next=l1
                l1=l1.next
            p=p.next
        if l1:
            p.next=l1
        if l2:
            p.next=l2
        return head.next