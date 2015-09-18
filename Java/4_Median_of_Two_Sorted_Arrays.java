public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int[] merge=new int[l1+l2];
        int ind1=0,ind2=0,i=0;
        double median;
        while(ind1<l1&&ind2<l2){
           if(nums1[ind1]<nums2[ind2]){
                merge[i]=nums1[ind1];
                ind1++;
           } else{
                merge[i]=nums2[ind2];
                ind2++;
           }
           i++;
        }
        while(ind1<l1){
            merge[i]=nums1[ind1];
            i++;
            ind1++;
        }
        while(ind2<l2){
            merge[i]=nums2[ind2];
            i++;
            ind2++;
        }
        median=(merge[merge.length/2]+merge[(merge.length-1)/2])/2.0;
        return median;
    }
}