import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int i,n=nums.length;
        for(i=n;n>1;n--){
            i*=n-1;
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int[] perm=nums;
        for(int j=0;j<i;j++){
            ArrayList<Integer> pe = new ArrayList<Integer>();
            for(int k=0;k<perm.length;k++){
                pe.add(perm[k]);
            }
            ret.add(pe);
            perm=next(perm);
        }
        return ret;
    }
    public static int[] next(int[] nums){
        int[] res=new int[nums.length];
        int start=nums.length-2;
        for(int i=0;i<nums.length;i++)res[i]=nums[i];
        while(start>=0 && res[start]>res[start+1])start--;
        if(start>=0){
            int tmp=start;
            if(start<res.length-2){
                while(tmp<res.length-1&&res[tmp+1]>res[start])tmp++;
            }else{
                tmp=start+1;
            }
            int tmp2=res[tmp];
            res[tmp]=res[start];
            res[start]=tmp2;
        }
        start++;
        reverse(res, start, res.length-1);
        return res;
    }
    public static void reverse(int[] nums, int start, int end){
        if(start<0||end>nums.length-1||nums.length==0||start>=end){
            return;
        }
        int tmp;
        while(start<end){
            tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] n={1,1,2};
        List<List<Integer>> res = new Solution().permute(n);
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
    
    public static <T extends Number> void print(T[] array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(T item:array){
            System.out.print(item+",");
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
//另附N皇后问题的构造解法 http://blog.sina.com.cn/s/blog_49f9e4fc0100c6n4.html