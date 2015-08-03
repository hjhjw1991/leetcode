# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def deleteDuplicates(self, head):
        if not head or not head.next:
            return head
        cur=head
        last=head.val
        while cur.next is not None:
            if cur.next.val!=last:
                last=cur.next.val
                cur=cur.next
            else:
                cur.next=cur.next.next
        return head