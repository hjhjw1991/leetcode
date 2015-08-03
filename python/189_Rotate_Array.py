class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {void} Do not return anything, modify nums in-place instead.
    def rotate(self, nums, k):
        if nums and len(nums)>1 and k>0:
            length=len(nums)
            k=k%length
            if k==0:
                return
            cur,i,root,times=nums[0],0,0,length
            while times>0:
                next=(i+k)%length
                cur,nums[next],i=nums[next],cur,next
                if i==root:
                    root=i=i+1
                    cur=nums[root]
                times=times-1