class Solution:
    # @param {string} s
    # @return {boolean}
    def isValid(self, s):
        stack=["+"]
        for p in s:
            if p in "([{":
                stack.append(p)
            else:
                if (p==")" and stack[-1]=="(") or (p=="]" and stack[-1]=="[") or (p=="}" and stack[-1]=="{"):
                    stack=stack[:-1]
                else:
                    return False
        if len(stack)>1:
            return False
        return True