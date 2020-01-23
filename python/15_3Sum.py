# coding=utf-8
import unittest
class Solution:
    def solve(self, nums):
        return self.threeSum(nums)
        
    # @param {integer[]} nums
    # @return {integer[][]}
    def threeSum(self, nums):
        length=len(nums)
        if length<3:
            return []
        nums=sorted(nums)
        dic={}
        for i in nums:
            if i in dic:
                dic[i]+=1
            else:
                dic[i]=1
        res=[]
        dic2={}
        for i in range(length-2):
            if nums[i] not in dic2:
                dic2[nums[i]]={}
            for j in range(i+1,length-1):
                if nums[j] not in dic2[nums[i]]:
                    dic2[nums[i]][nums[j]]=0
                    if -nums[i]-nums[j]>=nums[j] and -nums[i]-nums[j] in dic:
                        dic[nums[i]]-=1
                        dic[nums[j]]-=1
                        dic[-nums[i]-nums[j]]-=1
                        if dic[nums[i]]>=0 and dic[nums[j]]>=0 and dic[-nums[i]-nums[j]]>=0:
                            res.append([nums[i],nums[j],-nums[i]-nums[j]])
                        dic[nums[i]]+=1
                        dic[nums[j]]+=1
                        dic[-nums[i]-nums[j]]+=1
        return res
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        self.cases=[
        [-1,0,1,2,-1,-4],
        [0,0,0],
        [-2,1,1],
        [1,2,-2,-1]
                    ]
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print(("testcase: ", case))
            print(("result: ",self.s.solve(case)))
            # if assert is needed
            
unittest.main()

