# coding=utf-8
# #problem number 14
class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        if strs is None or len(strs)<1:
            return ''
        s0=strs[0]
        for s1 in strs:
            if s1[0:len(s0)]==s0:
                continue
            else:
                i = 0
                while i < min(len(s0),len(s1)) and s0[i]==s1[i]:
                    i+=1
                s0=s0[0:i]
        return s0
        
s=Solution()
test=[
    ['a', 'aa'],
    ['ab','abb','abc'],
    ['aba','abb','abc']]
print map(s.longestCommonPrefix, test)