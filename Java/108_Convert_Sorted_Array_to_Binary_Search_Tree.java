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
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums, 0, nums.length-1);
    }
    
    public static TreeNode arrayToBst(int[] nums, int from, int to){
        if(from>to||from<0||to>nums.length-1){
            return null;
        }else if(from==to){
            return new TreeNode(nums[from]);
        }
        int mid = (from+to)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBst(nums, from , mid-1);
        root.right = arrayToBst(nums, mid+1, to);
        return root;
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