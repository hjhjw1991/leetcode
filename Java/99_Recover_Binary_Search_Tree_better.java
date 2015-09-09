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
        int k = sc.nextInt();
        TreeNode root = t.new TreeNode(k);
        for(int i=1;i<n;i++){
            k=sc.nextInt();
            insert(root, t.new TreeNode(k));
        }
        pre=null;
        first=null;
        second=null;
        printTree(root);
        System.out.println();
        swapTree(root);
        recoverTree(root);
        printTree(root);
        System.out.println();
    }
    
    public static void insert(TreeNode root, TreeNode insert){
        if(root==null)return;
        if(insert.val<=root.val){
            if(root.left==null){
                root.left=insert;
            }else{
                insert(root.left, insert);
            }
        }else{
            if(root.right==null){
                root.right=insert;
            }else{
                insert(root.right, insert);
            }
        }
    }
    
    public static void swapTree(TreeNode root){
        if(root!=null&&root.left!=null&&root.right!=null){
            int temp=root.left.val;
            root.left.val=root.right.val;
            root.right.val=temp;
        }
    }
    public static void recoverTree(TreeNode root) {
        recoverTreeTraversal(root);
        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;
    }
    public static void recoverTreeTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        recoverTreeTraversal(root.left);
        if(pre!=null&&pre.val>root.val){
            if(first==null){
                first=pre;
                second=root;
            }else{
                second=root;
                return;
            }
        }
        pre=root;
        recoverTreeTraversal(root.right);
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
