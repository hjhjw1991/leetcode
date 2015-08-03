class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        if s is None or len(s)==0:
            return 0
        rtoi={
            'I':1,
            'V':5,
            'X':10,
            'L':50,
            'C':100,
            'D':500,
            'M':1000,
            }
        res = 0
        for i in range(len(s)):
            if i+1<len(s) and ((s[i]=='C' and s[i+1] in 'DM') or (s[i]=='X' and s[i+1] in 'LC') or (s[i]=='I' and s[i+1] in 'VX')):
                res -= rtoi[s[i]]
            else:
                res += rtoi[s[i]]
        return res
