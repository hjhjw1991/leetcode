import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import dutil.Print;

/**
    Test template
    You just need to extends Test and overrite method solve() and run()
    then call run() or run(file) in your main entry.
*/
public abstract class Test {
    public static boolean DEBUG = false;// I/O through console if debugging
    public static boolean STDOUT = true;
    public static boolean STDINPUT = false;
    public static String file;
    private static FileInputStream in;
    private static PrintStream out;
    private static InputStream stdin;
    private static PrintStream stdout;
    public void run(){
        run("in");
    }
    
    public void run(String inputfile){
        file=inputfile;
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
    protected abstract void solve(Scanner sc);
    
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