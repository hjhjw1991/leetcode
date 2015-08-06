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
        if not head or not head.next:
            return False
        cur=runner=head
        while runner and runner.next:
            cur=cur.next
            runner=runner.next
            runner=runner.next
            if cur==runner:
                return True
        return False