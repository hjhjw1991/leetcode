# TODO try to use yield and generator
class Solution:
    # @param {integer} n
    # @return {string}
    def countAndSay(self, n):
        if not n:
            return ''
        s='1'
        if n==1:
            return s
        for i in xrange(n-1):
            s=self.cnt(s)
        return s
    def cnt(self,s):
        last=s[0]
        count=1
        res=''
        for c in s[1:]:
            if last!=c:
                res=res+str(count)+last
                last=c
                count=1
            else:
                count+=1
        res=res+str(count)+last
        return res