public class Solution {
    public int bulbSwitch(int n) {
        // prime number must be 'off'
        // every number has even factors will be 'off'
        // n has n1 of p1, n2 of p2, p1 and p2 are prime, n has (n1+1)*(n2+1) factors
        // n is 'on' only when number of each factor is even, which means n is a square number
        if(n<1)return 0;
        int count=1;
        for(int i=2;i*i<=n;i++){
            count++;
        }
        return count;
    }
}