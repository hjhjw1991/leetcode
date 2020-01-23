# coding=utf-8
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @return {void} Do not return anything, modify head in-place instead.
    def reorderList(self, head):
        if not head or not head.__next__:
            return head
        node=[]
        while head:
            node.append(head)
            head=head.__next__
        l,r=0,len(node)-1
        while l<r:
            node[l].next=node[r]
            node[r].next=node[l+1]
            l+=1
            r-=1
        node[l].next=None
root=ListNode(1)
root.next=ListNode(2)
root.next.next=ListNode(3)
root.next.next.next=ListNode(4)
#root.next.next.next.next=ListNode(5)
so=Solution()
so.reorderList(root)
while root:
    print((root.val))
    root=root.__next__