# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        if not head or not head.__next__:
            return None
        cur=runner=head
        while runner and runner.__next__:
            cur=cur.__next__
            runner=runner.__next__
            runner=runner.__next__
            if cur==runner:
                cur=head
                while cur!=runner:
                    cur=cur.__next__
                    runner=runner.__next__
                return cur
        return None