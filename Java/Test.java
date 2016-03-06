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
    public static Scanner sc;
    private static FileInputStream in;
    private static PrintStream out;
    private static InputStream stdin;
    private static PrintStream stdout;
    
    //solves are related to concrete problems.
    public abstract void solve();
    protected abstract void solve(Scanner sc);
    
    //run on file 'in' with standard output
    public void debug(){
        DEBUG = false;
        STDOUT = true;
        STDINPUT = false;
        file = "in";
        setup();
    }
    public void noDebug(String inputfile){
        DEBUG = false;
        STDOUT = false;
        STDINPUT = false;
        file = inputfile;
        if(file==null)throw new IllegalArgumentException();
        setup();
    }
    
    private void setup(){
        if(!DEBUG){
            try{
                redirectStream(file);
            }catch(Exception e){
                return;
            }
        }
    }
    /**
    @param file set input and output using $file with extension ".in" and ".out"
    */
    public static void redirectStream(String file) throws Exception{
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