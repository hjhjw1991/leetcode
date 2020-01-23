class Solution:
    # @param {string} s1
    # @param {string} s2
    # @return {boolean}
    def isScramble(self, s1, s2):
        return self.find(s1,s2,{})
        
    def find(self, s1, s2, dic):
        if (s1,s2) in dic:
            return dic[(s1,s2)]
        elif sorted(s1)!=sorted(s2):
            return False
        else:
            dic[(s1,s2)] = s1==s2
            if not dic[(s1,s2)]:
                for i in range(1,len(s1)):
                    if (self.find(s1[:i],s2[:i],dic) and self.find(s1[i:],s2[i:],dic)) or (self.find(s1[:i],s2[-i:],dic) and self.find(s1[i:],s2[:-i],dic)):
                        dic[(s1,s2)]=True
                        break
            return dic[(s1,s2)]
        