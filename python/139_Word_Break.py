class Solution:
    # @param s, a string
    # @param wordDict, a set<string>
    # @return a boolean
    def wordBreak(self, s, wordDict):
        if not wordDict or not s:
            return False
        dp=[[] for i in range(len(s)+1)]
        dp[0]=1
        for i in xrange(1,len(s)+1):
            for j in xrange(i-1,-1,-1):
                if dp[j] and s[j:i] in wordDict:
                    dp[i]=1
                    break
        return dp[-1]==1