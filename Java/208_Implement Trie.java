/**
208. Implement Trie (Prefix Tree)
字典树，又叫单词树，常用于存储、排序和查询大量字符串，是哈希树的变种，经常被搜索引擎系统用于文本词频统计，优点是利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。
Implement a trie with insert, search, and startsWith methods.
*/
class TrieNode {
    // Initialize your data structure here.
    private int SIZE=26;
    public int num;//有多少单词通过这个节点,即节点字符出现的次数
    public TrieNode[]  son;//所有的儿子节点
    public boolean isEnd;//是不是最后一个节点
    public char val;//节点的值
    public TrieNode() {
        num=1;
        son=new TrieNode[SIZE];
        isEnd=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null||word.length()==0){
            return;
        }
        TrieNode node=root;
        char[] letters=word.toCharArray();
        for(int i=0,len=word.length();i<len;i++){
            int pos=letters[i]-'a';
            if(node.son[pos]==null){
                node.son[pos]=new TrieNode();
                node.son[pos].val=letters[i];
            }else{
                node.son[pos].num++;
            }
            node=node.son[pos];
        }
        node.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word==null||word.length()==0){
            return false;
        }
        TrieNode node=root;
        char[] letters=word.toCharArray();
        for(int i=0,len=word.length();i<len;i++){
            int pos=letters[i]-'a';
            if(node.son[pos]!=null){
                node=node.son[pos];
            }else{
                return false;
            }
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix==null||prefix.length()==0){
            return false;
        }
        TrieNode node=root;
        char[] letters=prefix.toCharArray();
        for(int i=0,len=prefix.length();i<len;i++){
            int pos=letters[i]-'a';
            if(node.son[pos]!=null){
                node=node.son[pos];
            }else{
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");