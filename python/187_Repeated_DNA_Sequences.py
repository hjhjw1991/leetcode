class Solution:
    # @param {string} s
    # @return {string[]}
    def findRepeatedDnaSequences(self, s):
        res = []
        dic = {"A":1, "C":2, "G":3, "T":4}
        dicDNA = {}
        num = 1
        for i in range(len(s)):
            num = (num*4 + dic[s[i]]) & 0XFFFFF
            if i < 9:
                continue
            if num not in dicDNA:
                dicDNA[num] = 1
            elif dicDNA[num] == 1:
                res.append(s[i-9:i+1])
                dicDNA[num] = 2
        return res