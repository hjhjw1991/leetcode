public class Solution {
    //considering overflow and ended with 000
    public int reverse(int x) {
        long r=0,j=x;
        while(j!=0 && r*10<=2147483647 && r*10>=-2147483648){
            r*=10;
            r+=j%10;
            j/=10;
        }
        return j==0?(int)r:0;
    }
    
    public static void main(String[] args){
        Solution sl = new Solution();
        int[] i={1,1230100,-123,1534236469};
        for(int x:i){
            System.out.println(sl.reverse(x));
        }
    }
}