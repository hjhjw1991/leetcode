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
    // solve is for solving a single case
    public static void solve(Scanner sc){
        String s = sc.next();
        String t = sc.next();
        System.out.println(s);
        System.out.println(t);
        System.out.println(numDistinct(s, t));
    }
    
    public static int numDistinct(String s, String t) {
        if(s==null){
            if(t==null){
                return 1;
            }else{
                return 0;
            }
        }
        int slen=s.length();
        int tlen=t.length();
        if(slen<tlen)return 0;
        if(s.equals(t))return 1;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int[] pre = new int[slen+1];
        int[] cur = new int[slen+1];
        for(int i=0;i<=slen;i++){
            pre[i]=1;
        }
        for(int i=1;i<=tlen;i++){
            for(int j=i;j<=slen;j++){
                if(schar[j-1]==tchar[i-1]){
                    cur[j]=pre[j-1]+cur[j-1];// if matched, then the current char may or may not be part of the subsequence.
                }else{
                    cur[j]=cur[j-1];// if not matched, then the number of subsequences is the same as current char is not present.
                }
            }
            for(int k=0;k<=slen;k++){
                pre[k]=cur[k];
                cur[k]=0;
            }
        }
        Print.print(pre);
        return pre[slen];
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
