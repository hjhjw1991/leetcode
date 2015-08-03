public class Solution {
    public int findMin(int[] num) {
        int L = 0, R = num.length - 1, M;
        if (R < 0) return -1;
        while (L < R) {
            M = L + (R - L) / 2;
            if (num[M] > num[R])
                L = M + 1;
            else
                R = M;
        }
        return num[L];
    }
}