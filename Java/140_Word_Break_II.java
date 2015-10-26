import java.util.Scanner;
import java.util.*;
//an example of using Test
public class Solution extends Test{
    protected void solve(Scanner sc){
        int num=sc.nextInt();
        Set<String> dict = new HashSet<>();
        for(int i=0;i<num;i++){
            dict.add(sc.next());
        }
        wordBreak(sc.next(), dict);
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> all = new ArrayList<>();
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0)return all;
        Set<Integer> lengths=new HashSet<Integer>();
        for(String str:wordDict){
            lengths.add(str.length());
        }
        int len=s.length(), start, end;
        LinkedList<Integer>[] dp=new LinkedList[len+1];
        LinkedList<Integer> startStack = new LinkedList<>();
        for(int i=1;i<=len;i++){
            dp[i]=new LinkedList<Integer>();// dp[i]存储所有s中以第i个字符为结尾的所有单词的开头下标的列表
        }
        // 从第0个位置开始，对每一个长度试探当前s子串，如果是单词表中的单词，则查看这个结尾位置是否已经有列表
        // 如果有列表，说明以该位置为开始位置的剩余串都已经探索过了，那么把该位置当前词对应的开始位置添加到列表中就行
        // 如果还没有列表，说明该结尾位置还没有作为开始位置进行过探索，那么把该位置加入到开始位置栈中，等待下一次探索
        startStack.add(0);
        while(startStack.size()>0){
            start = startStack.pollLast();
            for(int length:lengths){
                // System.out.println("Start " + start + " -- Length " + length );
                if(start+length<=len && wordDict.contains(s.substring(start, start+length))){
                    if(dp[start+length].size()==0){
                        startStack.add(start+length);
                    }
                    dp[start+length].add(start);
                }
            }
        }

        // 探索完毕之后进行字符提取和句子组合
        // 探索方式是：先将最后的位置入栈
        // 栈中保存每一种切割组合
        // 如果当前切割组合的开始位置已经是0下标位置，说明当前切割是对整个字符串的切割，将这个切割提取并加上空格，加入结果中
        // 否则，说明当前切割只是对后面某一部分的切割，以当前切割的起始位置为索引，找到其所有开头位置，加入到当前切割中，分别形成新的扩大的切割，并入栈
        LinkedList<LinkedList<Integer>> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<String> sentence;
        list.add(len);
        stack.add(list);
        while(stack.size()>0){
            list = stack.pollLast();
            if(list.peekFirst()==0){
                sentence = new ArrayList<String>();
                start = list.pollFirst();
                while(list.size()>0){
                    end = list.pollFirst();
                    sentence.add(s.substring(start, end));
                    start = end;
                }
                all.add(join(" ", sentence));
            }else{
                for(int sta:dp[list.peekFirst()]){
                    LinkedList<Integer> nlist = new LinkedList<>(list);
                    nlist.addFirst(sta);
                    stack.add(nlist);
                }
            }
        }
        for(String stt:all){
            System.out.println(stt);// 记得提交时去掉该输出语句
        }
        return all;
    }
    
    public String join(String delimiter, List<String> word){
        StringBuffer sb = new StringBuffer();
        int i;
        for(i=0;i<word.size()-1;i++){
            sb.append(word.get(i));
            sb.append(delimiter);
        }
        sb.append(word.get(i));
        return sb.toString();
    }
    
    public void solve(){
        sc = new Scanner(System.in);
        // below is related to concrete problems
        int T = sc.nextInt();
        //sc.nextLine();//jump over the first line. 
        for(int i=1;i<=T;i++){
            solve(sc);
        }
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        so.debug();
        //so.noDebug("2");
        so.solve();
    }
}