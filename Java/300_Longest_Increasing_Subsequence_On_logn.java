public class Solution {
    public int BinarySearch(int[] a, int l, int r, int key) {
        while (l <= r) {
            int m = l+(r-l)/2;
            if (a[m] >= key)
                r = m-1;
            else l = m+1;
        }
        return l;
    }
    public int lengthOfLIS(int[] nums) {
        // 想想这个题的数学本质，逆序数啊之类的，想明白了再提交
        int len = 0, n = nums.length;
        int[] a = new int[n];
        for (int i: nums) {
            int j = BinarySearch(a, 0, len-1, i);
            a[j] = i;
            if (j == len) len++;
        }
        return len;
    }
}