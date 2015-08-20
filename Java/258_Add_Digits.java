
/**
    Digital Root
    https://en.wikipedia.org/wiki/Digital_root
*/
public class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        return num-(num-1)/9 *9;
    }
}