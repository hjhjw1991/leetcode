/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        // map saves the relationship from original node to new node
        HashMap<Integer, UndirectedGraphNode> map=new HashMap<Integer, UndirectedGraphNode>();
        // stack saves the nodes whose neighbors are not visited yet
        LinkedList<UndirectedGraphNode> stack=new LinkedList<UndirectedGraphNode>();
        
        // 1. at first, clone the head node and save it in map, then add the head node into stack
        // 2. then poll a node from stack, visit it's neighbors and
        // 3. if neighbor is not cloned, clone it, put it in map, and push it in stack
        // 4. link the cloned neighbors to cloned node
        // 5. repeat 2-4 until stack is empty which means all nodes are in the map
        // 6. return
        UndirectedGraphNode cur;
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node.label, head);
        stack.add(node);
        while(stack.size()>0){
            cur=stack.pollFirst();
            for(UndirectedGraphNode ugn:cur.neighbors){
                if(!map.containsKey(ugn.label)){
                    map.put(ugn.label, new UndirectedGraphNode(ugn.label));
                    stack.add(ugn);
                }
                map.get(cur.label).neighbors.add(map.get(ugn.label));
            }
        }
        return head;
    }
}