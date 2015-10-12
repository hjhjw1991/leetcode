/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 构造出了一个leetcode本身的解会出错的testcase：
// [1,2,3] 1 7
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n<=0||m>=n||head==null||head.next==null)return head;
        ListNode dummy = new ListNode(0) ,runner;
        dummy.next = head;
        n=n-m;// 要操作的节点数，如果下面的条件是>0的话这里就应该+1
        runner = dummy;
        while(runner.next!=null && m>1){// 注意节点从1开始计数
            runner = runner.next;
            m--;
        }
        ListNode np = runner.next, p;
        runner.next=null;
        ListNode tail = np;// 保存翻转之后的尾节点，好接上剩余的链表
        while(np!=null&&n>=0){
            p=np.next;
            np.next=runner.next;
            runner.next=np;
            np=p;
            n--;
        }
        tail.next=np;
        return dummy.next;
    }
}