# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# 此题和142题均是CrackingTheCodingInterview里面的例题

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        if not head or not head.__next__:
            return False
        cur=runner=head
        while runner and runner.__next__:
            cur=cur.__next__
            runner=runner.__next__
            runner=runner.__next__
            if cur==runner:
                return True
        return False