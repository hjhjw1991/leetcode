class Solution:
    # @param {integer} x
    # @return {boolean}
    def isPalindrome(self, x):
        strx=str(x)
        stry=strx[::-1]
        return strx==stry