class Solution:
    # @param {string} str
    # @return {integer}
    def myAtoi(self, str):
        import sys
        if str is None or len(str)<1:
            return 0
        legal="0123456789"
        i=0
        while str[i]==" ":
            i+=1
        res=0
        sign=1
        if str[i] == "+":
            sign=1
            i+=1
        elif str[i] == "-":
            sign=-1
            i+=1
        while i < len(str):
            if str[i] not in legal:
                break
            else:
                res = res*10 + int(str[i])
            i+=1
        if sign==1 and res > 2147483647:
            return 2147483647
        elif sign==-1 and res > 2147483648:
            return -2147483648
        else:
            return res*sign