import java.util.*;

public class Solution {
    public void solveSudoku(char[][] board) {
        // states
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];//存储填写状态
        // 总体思路是回溯法解棋盘，当有任何一个解则返回true，若无解则返回false
        for(int i =0;i<9;i++){//初始化填写状态
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if( c== '.') continue;
                int t = c-'1';
                row[i][t]=true;
                col[j][t]=true;
                block[(i/3)*3+j/3][t] = true;
            }
        }
        solve(board,0,0,row,col,block);
    }
    
    //需要同时传递棋盘和数字填写状态
    public boolean solve(char[][] board,int i,int j,boolean[][] row,boolean[][] col,boolean[][] block){
        if(i == board.length) return true;// 如果到达棋盘外
        if(j == board[0].length) return solve(board,i+1,0,row,col,block);// 如果到达棋盘最右边
        if(board[i][j] != '.') return solve(board,i,j+1,row,col,block);// 如果当前位置不可填写
        //从1到9依次尝试填写到当前位置
        for(int num=0;num<9;num++){
            if(row[i][num]||col[j][num]||block[(i/3)*3+j/3][num]) continue;// 如果该数字已经填过则跳过
            board[i][j] = (char) ('1'+num);//填写数字
            row[i][num]=true;
            col[j][num]=true;
            block[(i/3)*3+j/3][num] = true;//修改状态
            if(solve(board,i,j+1,row,col,block)) return true;//尝试下一格
            board[i][j] = '.';//恢复棋盘
            row[i][num]=false;
            col[j][num]=false;
            block[(i/3)*3+j/3][num] = false;//恢复填写状态
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        char[][] board={
                {'5','3','.',   '.','7','.',    '.','.','.'},
                {'6','.','.',   '1','9','5',    '.','.','.'},
                {'.','9','8',   '.','.','.',    '.','6','.'},
                
                {'8','.','.',   '.','6','.',    '.','.','3'},
                {'4','.','.',   '8','.','3',    '.','.','1'},
                {'7','.','.',   '.','2','.',    '.','.','6'},
                
                {'.','6','.',   '.','.','.',    '2','8','.'},
                {'.','.','.',   '4','1','9',    '.','.','5'},
                {'.','.','.',   '.','8','.',    '.','7','9'},
            };
        print(board);
        so.solveSudoku(board);
        print(board);
    }
    
    public static void print(char[][] board){
        int i=0, j=0;
        for(char[] line:board){
            i++;
            for(char c:line){
                j++;
                System.out.print(c);
                System.out.print(" ");
                if(j%3==0){
                    System.out.print("   ");
                }
            }
            System.out.println();
            if(i%3==0){
                System.out.println();
            }
        }
    }
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(char res){
         System.out.println(res);
    }
    public static void print(boolean res){
         System.out.println(res);
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(long res){
         System.out.println(res);
    }
    
    public static <T extends Number> void print(T[] array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(T item:array){
            System.out.print(item+",");
        }
        System.out.println("]");
    }
    
    public static <T> void printList(List<T> array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(T item:array){
            System.out.print(item+",");
        }
        System.out.println("]");
    }
    
    public static <T> void printSet(Set<T> set){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(Iterator it=set.iterator();it.hasNext();){
            Object o=it.next();
            System.out.print(o+",");
        }
        System.out.println("]");
    }
    
    public static <T extends Number> void print(List<List<T>> ll){
        int i=0;
        for(List<T> l:ll){
            System.out.println("case " + i++);
            System.out.print("[");
            for(T s:l){
                System.out.print(s+",");
            }
            System.out.println("]");
        }
    }
}