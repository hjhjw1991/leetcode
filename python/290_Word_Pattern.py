class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        strs = str.split(" ")
        if len(pattern)!=len(strs):
            return False
        dic1={}# pattern to str
        dic2={}# str to pattern
        for i in range(len(pattern)):
            if (pattern[i] in dic1 and dic1[pattern[i]]!=strs[i]) or (strs[i] in dic2 and dic2[strs[i]]!=pattern[i]):
                return False
            else:
                dic1[pattern[i]]=strs[i]
                dic2[strs[i]]=pattern[i]
        return True