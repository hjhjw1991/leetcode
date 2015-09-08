import java.util.*;
import java.io.*;

public class Solution{
    static final String infile = "in.in";
    static final String outfile = "out.out";
    static final String debfile  = "debug.db";
    private static FileInputStream input;
    private static PrintStream ps;
    private static InputStream stdin;
    private static PrintStream stdout;
    private static final boolean DEBUG = true;

    public static void main(String argv[]) throws Exception{
        if(!DEBUG){
            redirectStream();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Started.");

        int T = in.nextInt();// total test cases
        for(int i = 1;i<=T; i++){
            System.out.printf("Case #%d: \n", i);
            solve();
        }
    }

    // solve just one case
    public static void solve(){
        Solution so = new Solution();
        char[][] board = {
            {'F', 'Y', 'C', 'E', 'N', 'R', 'D'},
            {'K', 'L', 'N', 'F', 'I', 'N', 'U'},
            {'A', 'A', 'A', 'R', 'A', 'H', 'R'},
            {'N', 'O', 'K', 'L', 'P', 'N', 'E'},
            {'A', 'L', 'A', 'N', 'S', 'A', 'P'},
            {'O', 'O', 'G', 'O', 'T', 'P', 'N'},
            {'H', 'P', 'O', 'L', 'A', 'N', 'D'},
        };
        String[] words = {
            "oog",
        };
        for(String word:words){
            System.out.println(word);
            System.out.println(so.exist(board, word));
        }
    }
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if(words.length==0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==words[0]&&find(board, words, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, char[] word, int curchar, int curi, int curj ){
        if(curchar>=word.length){
            return true;
        }else if(curi>=board.length||curj>=board[0].length||curi<0||curj<0){
            return false;
        }
        boolean ret;
        if(board[curi][curj] != word[curchar]){
            return false;
        }else{
            curchar++;
        }
        char ch = board[curi][curj];
        board[curi][curj] = '.';
        ret = find(board, word, curchar, curi, curj+1) || find(board, word, curchar, curi+1, curj) || find(board, word, curchar, curi-1, curj) || find(board, word, curchar, curi, curj-1);
        board[curi][curj] = ch;
        return ret;
    }

    public Solution(){
    }

    public static void redirectStream() throws Exception{
        input = new FileInputStream(infile);
        ps = new PrintStream(new FileOutputStream(outfile));
        stdin = System.in;
        stdout = System.out;
        System.setIn(input);
        System.setOut(ps);
    }

    public static void resetStream() throws Exception{
        input = null;
        ps = null;
        if(stdin!=null && stdout!=null){
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }

    static void print(int[] nums){
        for(int i:nums){
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    static void print(String[] strs){
        for(String str:strs){
            System.out.print(str);
            System.out.print("\t");
        }
        System.out.println();
    }
}