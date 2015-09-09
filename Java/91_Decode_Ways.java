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
    
    // solve is for solving a single case
    public static void solve(Scanner sc){
        String s = sc.next();
        char[] nums = s.toCharArray();
        if(nums==null||nums.length<1||nums[0]=='0'){
            System.out.println(0);
            return;
        }
        int length=nums.length;
        int[] dp = new int[2];
        dp[1]=1;
        int temp;
        if(nums[length-1]=='0')dp[0]=0;
        else dp[0]=1;
        for(int i=nums.length-2;i>=0;i--){
            temp=dp[0];
            if(nums[i]=='0'){temp=0;}
            else if(nums[i]-'0'<=2&&(nums[i]-'0'>1&&nums[i+1]-'0'<=6 || nums[i]-'0'>0 && nums[i]-'0'<2)){
                temp+=dp[1];
            }
            dp[1]=dp[0];
            dp[0]=temp;
        }
        System.out.println(dp[0]);
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