class Solution:
    # @param {integer} num
    # @return {string}
    def intToRoman(self, num):
        itor={'1':'I',
            '5':'V',
            '10':'X',
            '50':'L',
            '100':'C',
            '500':'D',
            '1000':'M',
            }
        dig=-1
        if num is None or num==0:
            return ''
        res=''
        while num!=0:
            rem = num % 10
            num /= 10
            dig += 1
            if rem < 4:
                res += itor['1'+'0'*dig]*rem
            elif rem == 4:
                res += itor['5'+'0'*dig]+itor['1'+'0'*dig]
            elif rem < 9:
                res += itor['1'+'0'*dig]*(rem-5)+itor['5'+'0'*dig]
            else:
                res += itor['1'+'0'*(dig+1)]+itor['1'+'0'*dig]
        return res[::-1]