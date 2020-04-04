/**

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        } else if (head.next == null) {
            return true;
        } else if (head.next.next == null && head.val == head.next.val) {
            return true;
        }
        
        // 找到链表中间位置
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 将后半部分反转
        ListNode left = head, right = slow.next;
        slow.next = null;
        ListNode nRight = reverse(right);
        right = nRight;
        
        // 比较回文
        boolean ret = false;
        while(nRight != null && left != null && nRight.val == left.val) {
            nRight = nRight.next;
            left = left.next;
        }
        ret = nRight == null;
        
        // 恢复原链表
        slow.next = reverse(right);
        return ret;
    }
    // 遍历两次链表, 反转两次链表, 时间复杂度O(3n), 原地反转空间复杂度O(1)
    
    public ListNode reverse(ListNode head) {
        ListNode nHead = null, p;
        while(head != null) {
            // 保存当前表头
            p = nHead;
            // 插入节点到表头
            nHead = head;
            head = head.next;
            nHead.next = p;
        }
        return nHead;
    }
}