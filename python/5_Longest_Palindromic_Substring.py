class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
        if not s or len(s)<2:
            return s
        news="#".join(s)
        news="#"+news+"#"
        maxlen,anchor,p,length=1,0,{},len(news)
        p[0]=1
        index=0
        for cur in range(1,length):
            if p[anchor]+anchor>cur:
                p[cur]=min(p[anchor-(cur-anchor)],p[anchor]-(cur-anchor))
            else:
                p[cur]=1
            while cur>=p[cur] and cur+p[cur]<length and news[cur+p[cur]]==news[cur-p[cur]]:
                p[cur]=p[cur]+1
            if p[anchor]+anchor<p[cur]+cur:
                anchor=cur
            if maxlen<p[anchor]:
                maxlen=p[anchor]
                index=anchor
        return s[index/2-(maxlen-1)/2:index/2+maxlen/2]