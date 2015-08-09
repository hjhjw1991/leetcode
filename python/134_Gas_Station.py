import unittest

class Solution:
    def solve(self, gas, cost):
        return self.canCompleteCircuit(gas, cost)
        
    # @param {integer[]} gas
    # @param {integer[]} cost
    # @return {integer}
    def canCompleteCircuit(self, gas, cost):
        length=len(gas)
        index,end=length-1,0
        contain=0
        while index>=end:
            if contain+gas[end]-cost[end]>=0:
                contain=contain+gas[end]-cost[end]
                end=end+1
            else:
                contain=contain+gas[index]-cost[index]
                index=index-1
        return (index+1)%length if contain>=0 else -1
        
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        case=[
        ([4],[5]),#-1
        ([1,2,2],[1,2,2]),#0
        ([1,2,2],[1,2,3]),#-1
        ([1,3,2],[1,1,3]),#0
        ([8,2,4],[7,4,1]),#-1
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case[0],case[1]
            res=self.s.solve(case[0],case[1])
            print "result: ",res
            # if assert is needed
            
unittest.main()