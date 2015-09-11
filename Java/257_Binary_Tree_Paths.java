import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> all=new ArrayList<String>();
        if(root==null)return all;
        getPath(root, new StringBuffer(), all);
        return all;
    }
    public void getPath(TreeNode root, StringBuffer path, ArrayList<String> all){
        if(root==null)return;
        path.append(String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            all.add(path.toString());
        }else{
            path.append("->");
            StringBuffer left = new StringBuffer(path.toString());
            StringBuffer right = new StringBuffer(path.toString());
            getPath(root.left, left, all);
            getPath(root.right, right, all);
        }
    }
}