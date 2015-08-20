import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*
http://www.jb51.net/article/37318.htm
下面是算法的高级伪码描述，这里用一个N*N的矩阵来存储棋盘：
1) 算法开始, 清空棋盘，当前行设为第一行，当前列设为第一列
2) 在当前行，当前列的位置上判断是否满足条件(即保证经过这一点的行,列与斜线上都没有两个皇后)，若不满足，跳到第4步
3) 在当前位置上满足条件的情形：
在当前位置放一个皇后，若当前行是最后一行，记录一个解；
若当前行不是最后一行，当前行设为下一行, 当前列设为当前行的第一个待测位置；
若当前行是最后一行，当前列不是最后一列，当前列设为下一列；
若当前行是最后一行，当前列是最后一列，回溯，即清空当前行及以下各行的棋盘，然后，当前行设为上一行，当前列设为当前行的下一个待测位置；
以上返回到第2步
4) 在当前位置上不满足条件的情形：
若当前列不是最后一列，当前列设为下一列，返回到第2步;
若当前列是最后一列了，回溯，即，若当前行已经是第一行了，算法退出，否则，清空当前行及以下各行的棋盘，然后，当前行设为上一行，当前列设为当前行的下一个待测位置，返回到第2步; 
算法的基本原理是上面这个样子，但不同的是用的数据结构不同，检查某个位置是否满足条件的方法也不同。为了提高效率，有各种优化策略，如多线程，多分配内存表示棋盘等。
*/
/*
把棋盘存储为一个N维数组a[N]，数组中第i个元素的值代表第i行的皇后位置，这样便可以把问题的空间规模压缩为一维O(N)，在判断是否冲突时也很简单，首先每行只有一个皇后，且在数组中只占据一个元素的位置，行冲突就不存在了，其次是列冲突，判断一下是否有a[i]与当前要放置皇后的列j相等即可。至于斜线冲突，通过观察可以发现所有在斜线上冲突的皇后的位置都有规律即它们所在的行列互减的绝对值相等，即| row – i | = | col – a[i] | 。这样某个位置是否可以放置皇后的问题已经解决。
*/
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        //it's a typical NP problem. So time complexity is more than O(n^x)
        char queen='Q';
        char empty='.';
        List<List<String>> res=new ArrayList<List<String>>();
        int[] a=new int[n+2];//记录第j行皇后的位置a[j]，这是一个简化后的棋盘，前后各留出一位来方便操作
        int j=1,count=0;//j为行数，从1开始
        a[j]=1;
        while(j>0){
            if(j<=n&&a[j]<=n){
                //对第j列开始探索
                if(!isValid(a,j)){
                    a[j]++;
                }
                else{
                    j++;
                    a[j]=1;
                }
            }else{
                if(j>n){
                    //到达了最后一行
                    count++;
                    //记录解
                    res.add(record(a,n,queen,empty));
                }
//如果k>n会执行下面两行代码，因为虽然找到了N皇后问题的一个解，但是要找的是所有解，需要回溯，从当前放置皇后的下一列继续探测
//如果a[k]>n也会执行下面两行代码，就是说在当前行没有找到可以放置皇后的位置，于是回溯，从上一行皇后位置的下一列继续探测
                j--;
                a[j]++;
            }
        }
        return res;
    }
    
    //判断是否可以放置皇后
    public static boolean isValid(int[] a, int row){
        for(int i=1;i<row;i++){
            if(a[i]==a[row]||(a[i]-a[row]==i-row)||(a[i]-a[row]==row-i)){
                return false;
            }
        }
        return true;
    }
    
    //组装棋盘
    public static ArrayList<String> record(int[] a,int n, char queen, char empty){
        StringBuffer sb = new StringBuffer();
        ArrayList<String> res = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            sb.setLength(0);
            for(int j=1;j<=n;j++){
                if(j==a[i]){
                    sb.append(queen);
                }else{
                    sb.append(empty);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    public static void main(String[] args) {
        int n=7;
        List<List<String>> res = new Solution().solveNQueens(n);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(List<List<String>> ll){
        int i=0;
        for(List<String> l:ll){
            System.out.println("case " + i++);
            for(String s:l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
//另附N皇后问题的构造解法 http://blog.sina.com.cn/s/blog_49f9e4fc0100c6n4.html