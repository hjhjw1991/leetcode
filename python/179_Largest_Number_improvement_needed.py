# coding=utf-8
import unittest
class Solution:
    def solve(self, nums):
        return self.largestNumber(nums)
        
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        def lt(str1,str2):
            l1=len(str1)
            l2=len(str2)
            if l1==l2:
                return int(str1)<int(str2)
            else:
                str11=str1+str2
                str22=str2+str1
                for l in range(l1+l2):
                    if str11[l]==str22[l]:
                        continue
                    return int(str11[l])<int(str22[l])
                return False
        def sort(strnum,l,r):
            if not strnum or l>=r:
                return
            left=l
            right=r
            cur=left
            soldier = strnum[l]
            while left<right:
                if cur==left:
                    if lt(soldier, strnum[right]):
                        strnum[cur]=strnum[right]
                        cur=right
                    else:
                        right-=1
                    continue
                elif cur==right:
                    if lt(strnum[left],soldier):
                        strnum[cur]=strnum[left]
                        cur=left
                    else:
                        left+=1
            strnum[cur]=soldier
            sort(strnum,l,cur-1)
            sort(strnum,cur+1,r)
        if not nums:
            return ""
        strnums=list(map(str,nums))
        sort(strnums,0,len(strnums)-1)
        res="".join(strnums)
        i=0
        while i<len(res):
            if res[i]!="0":
                break;
            i+=1
        if i==len(res):
            res="0"
        else:
            res=res[i:]
        return res
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print("TestComplete")
        
    def genTestCase(self):
        self.cases=[
        [0],
        [0,0],
        [121,12],
        [1440,7548,4240,6616,733,4712,883,8,9576],
        [824,938,1399,5607,6973,5703,9609,4398,8247],
        #[4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398]
                    ]
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print(("testcase: ", case))
            print(("result: ",self.s.solve(case)))
            # if assert is needed
            
unittest.main()

