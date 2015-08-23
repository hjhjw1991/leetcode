import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1,n);
    }
    
    public static List<TreeNode> genTrees(int from, int to){
        List<TreeNode> res = new ArrayList<TreeNode>();
        TreeNode root=null;
        if(to < from){
            res.add(root);//OJ for this problem accepts a [[]] returned rather than a [] when n==0. Thus I have to add a null node and return it.
            return res;
        }else if(to==from){
            res.add(new TreeNode(from));
            return res;
        }else{
            List<TreeNode> left,right;
            for(int i=from;i<=to;i++){
                left=genTrees(from,i-1);
                right=genTrees(i+1,to);
                if(left==null){
                    for(TreeNode rightnode:right){
                        root=new TreeNode(i);
                        root.left=null;
                        root.right=rightnode;
                        res.add(root);
                    }
                }else if(right==null){
                    for(TreeNode leftnode:left){
                        root=new TreeNode(i);
                        root.left=leftnode;
                        root.right=null;
                        res.add(root);
                    }
                }else{
                    for(TreeNode leftnode:left){
                        for(TreeNode rightnode:right){
                            root=new TreeNode(i);
                            root.left=leftnode;
                            root.right=rightnode;
                            res.add(root);
                        }
                    }
                }
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
        int n=3;
        int res = new Solution().numTrees(n);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(List<List<String>> ll){
        int i=0;
        for(List<String> l:ll){
            System.out.println("case " + i++);
            for(String s:l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
//另附N皇后问题的构造解法 http://blog.sina.com.cn/s/blog_49f9e4fc0100c6n4.html