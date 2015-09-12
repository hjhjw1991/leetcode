import java.util.Scanner;
//an example of using Test
public class Solution extends Test{
    DEBUG = false;
    STDIN = false;
    STDOUT = true;

    protected void solve(Scanner sc){
        int N = sc.nextInt();
        int[] citations = new int[N];
        for(int i=0;i<N;i++){
            citations[i] = sc.nextInt();
        }
        System.out.println(hIndex(citations));
    }

// It is a binary search problem
    public int hIndex(int[] citations) {
        int len=citations.length;
        if(len<1){
            return 0;
        }
        int i = 0, pre = 0;
        int left = 0,right = len-1, mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(citations[mid]>=len-mid&&(mid==0||citations[mid-1]<len-mid+1)){
                break;
            }else if(citations[mid]>=len-mid){ 
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(left>=len){
            return 0;// handle the situation that there is no such H.
        }
        return len-mid;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        file = "in";
        so.run(file);
    }
}