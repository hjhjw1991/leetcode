import java.util.Scanner;
//an example of using Test
public class Solution extends Test{
    protected void solve(Scanner sc){
        System.out.println(sc.nextLine());
    }
    
    public void solve(){
        sc = new Scanner(System.in);
        // below is related to concrete problems
        int T = sc.nextInt();
        sc.nextLine();//jump over the first line. 
        for(int i=1;i<=T;i++){
            solve(sc);
        }
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        so.debug();
        //so.noDebug("2");
        so.solve();
    }
}