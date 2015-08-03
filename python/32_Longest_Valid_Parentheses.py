class Solution:
    # @param {string} s
    # @return {integer}
    def longestValidParentheses(self, s):
        if not s or "(" not in s or ")" not in s:
            return 0
        index,res,length=0,[0]*len(s),len(s)
        record=[]
        while index<length:
            if s[index]=="(":
                record.append(index)
            elif record:
                p=record.pop()
                if index>0 and index - p == res[index-1]+1:
                    res[index] = res[index-1] + 2
                    if p > 0:
                        res[index] += res[p-1]
            index=index+1
        return max(res)