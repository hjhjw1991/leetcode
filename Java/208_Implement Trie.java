/**
208. Implement Trie (Prefix Tree)
�ֵ������ֽе������������ڴ洢������Ͳ�ѯ�����ַ������ǹ�ϣ���ı��֣���������������ϵͳ�����ı���Ƶͳ�ƣ��ŵ��������ַ����Ĺ���ǰ׺�����ٲ�ѯʱ�䣬����޶ȵؼ�����ν���ַ����Ƚϣ���ѯЧ�ʱȹ�ϣ���ߡ�
Implement a trie with insert, search, and startsWith methods.
*/
class TrieNode {
    // Initialize your data structure here.
    private int SIZE=26;
    public int num;//�ж��ٵ���ͨ������ڵ�,���ڵ��ַ����ֵĴ���
    public TrieNode[]  son;//���еĶ��ӽڵ�
    public boolean isEnd;//�ǲ������һ���ڵ�
    public char val;//�ڵ��ֵ
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