public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i;
        if(n<=0)return ;
        else if(m<=0){
            for(i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        i=m+n-1;
        while(m>0&&n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[i]=nums1[m-1];
                m--;
            }else{
                nums1[i]=nums2[n-1];
                n--;
            }
            i--;
        }
        while(n>0){
            nums1[i]=nums2[n-1];
            i--;
            n--;
        }
    }
}