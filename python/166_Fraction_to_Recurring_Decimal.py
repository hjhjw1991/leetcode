class Solution:
    # @param {integer} numerator
    # @param {integer} denominator
    # @return {string}
    def fractionToDecimal(self, numerator, denominator):
        if denominator==0:
            return ""
        isNeg= (numerator<0 and denominator>0) or (numerator>0 and denominator<0)
        numerator, denominator=abs(numerator),abs(denominator)
        res=str(numerator/denominator)
        if isNeg:
            res="-"+res
        rem=numerator%denominator
        pos=0
        dic={rem:pos}
        if rem==0:
            return res
        else:
            res+="."
            fraction=""
            while rem!=0:
                rem*=10
                fraction+=str(rem/denominator)
                rem=rem%denominator
                pos+=1
                if rem in dic:
                    break
                else:
                    dic[rem]=pos
        frac=str(fraction)
        if rem!=0:
            res+=frac[:dic[rem]]+"("+frac[dic[rem]:]+")"
        else:
            res+=frac
        return res