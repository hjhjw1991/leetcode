# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def deleteDuplicates(self, head):
        if not head or not head.__next__:
            return head
        cur=head
        last=head.val
        while cur.__next__ is not None:
            if cur.next.val!=last:
                last=cur.next.val
                cur=cur.__next__
            else:
                cur.next=cur.next.__next__
        return head