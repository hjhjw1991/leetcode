import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import dutil.Print;

public class Test {
    public static final boolean DEBUG = false;// I/O through console if debugging
    public static final boolean STDOUT = true;
    public static final boolean STDINPUT = false;
    private static String file;
    
    private static FileInputStream in;
    private static PrintStream out;
    private static InputStream stdin;
    private static PrintStream stdout;
    private static Test t=new Test();
    public static void main(String[] args){
        file="in";
        if(!DEBUG){
            try{
                redirectStream();
            }catch(Exception e){
                return;
            }
        }
        
        // below is related to concrete problems
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            solve(sc);
        }
    }
    public static TreeNode pre,first,second;
    // solve is for solving a single case
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        printTree(t.buildTree(preorder, inorder));
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        return buildSubtree(preorder, inorder, 0, 0, preorder.length-1);
    }
    
    // the first element of preorder must be the root, so we just need to decide where to divide the nodes in inorder array.
    public TreeNode buildSubtree(int[] preorder, int[] inorder, int rootindex, int from, int to){
        if(to<from||from>=preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[rootindex]);
        int newto=from;
        while(newto<=to&&preorder[rootindex]!=inorder[newto])newto++;//find the divide position
        root.left=buildSubtree(preorder, inorder, rootindex+1, from, newto-1);
        root.right=buildSubtree(preorder, inorder, rootindex+1+newto-from, newto+1, to);
        return root;
    }
     
    public static void printTree(TreeNode root){
        if(root==null){
            System.out.print(",#");
            return;
        }
        printTree(root.left);
        System.out.print(","+root.val);
        printTree(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static void redirectStream() throws Exception{
        if(file != null){
            stdin = System.in;
            stdout = System.out;
            if(!STDINPUT){
                in = new FileInputStream(file+".in");
                System.setIn(in);
            }
            if(!STDOUT){
                out = new PrintStream(new FileOutputStream(file+".out"));
                System.setOut(out);
            }
        }
    }
    
    public static void resetStream(){
        if(stdin !=null && stdout != null){
            in = null;
            out = null;
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }
}
