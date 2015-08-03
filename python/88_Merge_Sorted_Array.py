class Solution:
    # @param {integer[]} nums1
    # @param {integer} m
    # @param {integer[]} nums2
    # @param {integer} n
    # @return {void} Do not return anything, modify nums1 in-place instead.
    def merge(self, nums1, m, nums2, n):
        if m==0:
            i=0
            while i<n:
                nums1[i]=nums2[i]
                i+=1
        elif n>0:
            cur,n1,n2=m+n-1,m-1,n-1
            while n1>=0 and n2>=0:
                if nums1[n1]>nums2[n2]:
                    nums1[cur]=nums1[n1]
                    n1-=1
                else:
                    nums1[cur]=nums2[n2]
                    n2-=1
                cur-=1
            while n2>=0:
                nums1[n2]=nums2[n2]
                n2-=1