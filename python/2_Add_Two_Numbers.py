# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        c=0
        p=h=ListNode(0)
        while not (l1 is None or l2 is None):
            s = ListNode(l1.val + l2.val + c)
            c = s.val/10
            s.val = s.val%10
            p.next = s
            p = s
            l1 = l1.__next__
            l2 = l2.__next__
        while l1 is not None:
            s = ListNode(l1.val + c)
            c = s.val/10
            s.val = s.val%10
            p.next = s
            p = s
            l1 = l1.__next__
        while l2 is not None:
            s = ListNode(l2.val + c)
            c = s.val/10
            s.val = s.val%10
            p.next = s
            p = s
            l2 = l2.__next__
        if c > 0:
            s = ListNode(c)
            p.next = s
        return h.__next__