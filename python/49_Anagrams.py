class Solution:
    # @param {string[]} strs
    # @return {string[]}
    def anagrams(self, strs):
        result, output = {}, []
        for str in strs:
            key = ''.join(sorted(str))
            if key in result:
                result[key].append(str)
            else:
                result[key] = [str]

        for re in list(result.values()):
            if len(re) > 1:
                output += re

        return output