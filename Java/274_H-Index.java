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

    // brute searching
    // this is not an elegant solution. binary search should be considered, as is done in H-Index II.
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        if(len<1){
            return 0;
        }
        int i = 0;
        while(len>0&&citations[len-1]>=i+1){
            len--;
            i++;
        }
        return i;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        file = "in";
        so.run(file);
    }
}