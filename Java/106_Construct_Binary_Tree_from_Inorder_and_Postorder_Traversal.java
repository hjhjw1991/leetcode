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
        int[] postorder = new int[n];
        int[] inorder = new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt();
        }
        printTree(t.buildTree(inorder, postorder));
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0){
            return null;
        }
        return buildSubtree(postorder, inorder, postorder.length-1, 0, postorder.length-1);// changed from #105
    }
    
    // the last element of postorder must be the root, so we just need to decide where to divide the nodes in inorder array.
    // ~336ms
    public TreeNode buildSubtree(int[] postorder, int[] inorder, int rootindex, int from, int to){
        if(to<from||from>=postorder.length||rootindex<0){
            return null;
        }
        TreeNode root=new TreeNode(postorder[rootindex]);
        int newto=to;
        while(newto>=from&&postorder[rootindex]!=inorder[newto])newto--;//find the divide position. changed from #105
        root.right=buildSubtree(postorder, inorder, rootindex-1, newto+1, to);// changed from #105
        root.left=buildSubtree(postorder, inorder, rootindex-1-to+newto, from, newto-1);// changed from #105
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
