class Solution:
    # @param {integer[]} digits
    # @return {integer[]}
    def plusOne(self, digits):
        digits[-1]=digits[-1]+1
        for index in range(len(digits)-1,-1,-1):
            c=digits[index]/10
            if c!=0:
                digits[index]=digits[index]%10
                if index>0:
                    digits[index-1]+=c
                else:
                    digits=[c]+digits
        return digits