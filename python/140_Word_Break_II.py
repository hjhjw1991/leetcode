class Solution:
    # @param s, a string
    # @param wordDict, a set<string>
    # @return a string[]
    def wordBreak(self, s, wordDict):
        from collections import defaultdict
        sentences = []
        # get lengths of words
        stack, wordLengths = [0], set(map(len, wordDict))
        words = defaultdict(set)
        while stack:
            start = stack.pop()
            # check all word lengths
            for length in wordLengths:
                end = start + length
                if s[start : end] in wordDict:
                    if end not in words:
                        # push end of word onto stack
                        stack.append(end)
                    # add word start
                    words[end].add(start)

        stack = [[len(s)]]
        while stack:
            indices = stack.pop()
            if indices[0] == 0:
                # reach start of input string
                word = [s[i:j] for i, j in zip(indices[:-1], indices[1:])]
                sentences.append(' '.join(word))
            else:
                # append word start to the front of word break list
                stack.extend([[start] + indices for start in words[indices[0]]])

        return sentences