public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<String> list=new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        list.add(beginWord);
        visited.add(beginWord);
        int level=1;
        while(list.size()>0){
            LinkedList<String> next=new LinkedList<String>();
            for(String cur:list){
                for(int i=0;i<cur.length();i++){
                    char[] chars=cur.toCharArray();
                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String str=new String(chars);
                        if(endWord.equals(str)){
                            return level+1;
                        }
                        if(wordDict.contains(str)&&!visited.contains(str)){
                            next.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            level++;
            list=next;
        }
        return 0;
    }
}
//another solution, a bit faster
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<String> list=new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        list.add(beginWord);
        list.add(null);
        visited.add(beginWord);
        int level=1;
        while(list.size()>0){
            String cur=list.pollFirst();
            if(cur!=null){
                for(int i=0;i<cur.length();i++){
                    char[] chars=cur.toCharArray();
                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String str=new String(chars);
                        if(endWord.equals(str)){
                            return level+1;
                        }
                        if(wordDict.contains(str)&&!visited.contains(str)){
                            list.add(str);
                            visited.add(str);
                        }
                    }
                }
            }else{
                level++;
                if(list.size()>0){
                    list.add(null);
                }
            }
        }
        return 0;
    }
}