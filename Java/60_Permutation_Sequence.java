import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Character> valid = new ArrayList<Character>();
        int sum, i;
        for(i=1;i<=n;i++){
            valid.add((char)(i+'0'));
        }
        StringBuffer pre = new StringBuffer();
        getPer(valid, pre, n, k-1);
        return pre.toString();
    }
    
    public void getPer(ArrayList<Character> valid, StringBuffer pre, int n, int k){
        if(n<=0){
            return;
        }else if(k<=0){
            for(char c:valid){
                pre.append(c);
            }
            return;
        }
        int sum=1, i=1;
        for(;i<n;i++){
            sum*=i;
        }
        pre.append(valid.remove(k/sum));
        k = k%sum;
        getPer(valid, pre, n-1, k);
    }
    
    public static void main(String argv[]){
        Solution so=new Solution();
        int n = 8;
        int k = 31492;
        //int n = 4;
        //int k = 4;
        print(so.getPermutation(n, k));
    }
    
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
    
    static void print(String str){
        System.out.println(str);
    }
}