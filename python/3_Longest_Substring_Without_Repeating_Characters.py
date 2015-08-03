class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstring(self, s):
        if len(s)<1:
            return 0
        (ans,l,r) = (1,0,0)
        visit={}
        while l<=r and r<len(s):
            while r<len(s) and s[r] not in visit:
                visit[s[r]]=True
                r+=1
            ans=max(ans,r-l)
            while l<r and r<len(s) and s[l]!=s[r]:
                del(visit[s[l]])
                l+=1
            l+=1
            r+=1
        return ans