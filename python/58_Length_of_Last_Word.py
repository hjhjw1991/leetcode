class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLastWord(self, s):
        if len(s)<1:
            return 0
        length=0
        index=len(s)-1
        while index >= 0 and s[index]==" ":
            index -= 1
        while index >= 0 and s[index]!=" ":
            index -= 1
            length += 1
        return length