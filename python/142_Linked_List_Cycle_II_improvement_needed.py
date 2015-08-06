# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        if not head or not head.next:
            return None
        cur=runner=head
        while runner and runner.next:
            cur=cur.next
            runner=runner.next
            runner=runner.next
            if cur==runner:
                cur=head
                while cur!=runner:
                    cur=cur.next
                    runner=runner.next
                return cur
        return None