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
        List<String> res = new ArrayList<String>();
        if(s==null||s.length()<4||s.length()>12){
            return;
        }
        nextip(s, 0, new LinkedList<String>(), res);
    }
    
    public static void nextip(String digits, int from, LinkedList<String> pre, List<String> res){
        if(from>digits.length()||from<digits.length()&&pre.size()>=4){
            return;
        }else if(from==digits.length()&&pre.size()==4){
            StringBuffer sb = new StringBuffer(pre.get(0));
            for(int i=1;i<4;i++){
                sb.append(".");
                sb.append(pre.get(i));
            }
            for(String s:pre){
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
            res.add(sb.toString());
            return;
        }
        for(int i=from;i<from+3&&i<digits.length();i++){
            if(Integer.valueOf(digits.substring(from, i+1))<=255){
                if(digits.charAt(from)=='0'&&i-from>0)return;
                pre.add(digits.substring(from, i+1));
                nextip(digits, i+1, pre, res);
                pre.pollLast();
            }
        }
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