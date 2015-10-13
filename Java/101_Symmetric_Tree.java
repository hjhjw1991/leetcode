/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 树的广度遍历/层序遍历
public class Solution {
    // 由于要比较的含有位置信息，即左边和右边，所以只能通过父节点来比较
    // 对root的左子树和右子树分别层序遍历，顺序是左子树从左到右，右子树从右到左
    // 然后对每一层第i个节点，比较左子树左节点与右子树右节点，左子树右节点与右子树左节点
    // 比较时，只有两方其中一方为空另一方不空，或者两方都不空但值不相等，才返回false
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(root.left==null||root.right==null){
            return root.left==root.right;
        }
        ArrayList<TreeNode> queuel = new ArrayList<>(), queuer = new ArrayList<>(), nextl, nextr;
        TreeNode l, r;
        int len;
        queuel.add(root);
        queuer.add(root);
        while(queuel.size()>0&&queuer.size()==queuel.size()){
            nextl = new ArrayList<>();
            nextr = new ArrayList<>();
            len=queuel.size();
            for(int i=0;i<len;i++){
                l=queuel.get(i);
                r=queuer.get(i);
                if(l.left!=null||r.right!=null){
                    if(l.left==null||r.right==null||l.left.val!=r.right.val)return false;
                    nextl.add(l.left);
                    nextr.add(r.right);
                }
                if(l.right!=null||r.left!=null){
                    if(l.right==null||r.left==null||l.right.val!=r.left.val)return false;
                    nextl.add(l.right);
                    nextr.add(r.left);
                }
            }
            queuel=nextl;
            queuer=nextr;
        }
        if(queuer.size()!=queuel.size())return false;
        return true;
    }
}