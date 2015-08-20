import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*
从51很容易改成52
*/
public class Solution {
    public int totalNQueens(int n) {
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
    
    public static void main(String[] args) {
        int n=7;
        int res = new Solution().solveNQueens(n);
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