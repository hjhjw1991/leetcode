/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 import java.util.HashMap;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode pre=new RandomListNode(0);
        RandomListNode cur=head;
        head=pre;
        RandomListNode node;
        HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
        while(cur!=null){
            node = new RandomListNode(cur.label);
            map.put(cur,node);
            if(cur.random!=null && map.containsKey(cur.random)){
                node.random = map.get(cur.random);
            }else if(cur.random!=null){
                node.random = new RandomListNode(cur.random.label);
                // it's a wrong answer. see the comments in the python solution
            }else{
                node.random = null;
            }
            pre.next=node;
            pre=node;
            cur=cur.next;
        }
        return head.next;
    }
}