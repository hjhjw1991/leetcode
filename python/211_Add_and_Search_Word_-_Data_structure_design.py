class charNode:
	def __init__(self,x):
		self.val=x
		self.isEnd=False
		self.char={}

class WordDictionary:
	def __init__(self):
		self.root=charNode("")
	def addWord(self,word):
		trie=self.root
		for char in word:
			if char not in trie.char:
				trie.char[char]=charNode(char)
			trie=trie.char[char]
		trie.isEnd=True	

	def search(self,word):
		return self.searchN(self.root,word)

	def searchN(self,trie,word):
		trieNow=trie
		if not trie or not word:
			return False
		for i in xrange(len(word)):
			char=word[i]
			if char not in trieNow.char and char != ".":
				return False
			elif char==".":
				if i==len(word)-1:
					for char in trieNow.char:
						if trieNow.char[char].isEnd:
							return True
				else:
					for char in trieNow.char:
						if self.searchN(trieNow.char[char],word[i+1:]):
							return True
				return False
			else:
				trieNow=trieNow.char[char]
		return trieNow.isEnd  

if __name__ =="__main__":
    wordDictionary = WordDictionary()
    wordDictionary.addWord("a")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    print wordDictionary.search(".a")
    print wordDictionary.search("..d")
    print wordDictionary.search(".a.")
    print wordDictionary.search("b..")
# Your WordDictionary object will be instantiated and called as such:
# wordDictionary = WordDictionary()
# wordDictionary.addWord("word")
# wordDictionary.search("pattern")