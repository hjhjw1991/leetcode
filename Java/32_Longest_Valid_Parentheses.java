public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0)return 0;
        char[] parent=s.toCharArray();
        int len=parent.length;
        int index=0,pre;
        int[] res = new int[len];//默认为0
        int ret = 0;
        LinkedList<Integer> stack=new LinkedList<>();// 存储所有左括号的下标
        while(index<len){
            if(parent[index]=='('){
                stack.add(index);
            }else if(stack.size()>0){//如果有未匹配的左括号
                pre=stack.pollLast();//取得上一个左括号的下标
                if(index>0 && index-pre==res[index-1]+1){// 如果当前下标与上一个左括号的下标之差，等于index-1处连续最大的合法括号长度加1，即当前左右括号包含index-1位置为止最长合法括号
                // index-pre+1 == res[index-1]+2
                    res[index]=res[index-1]+2;//则当前最长为上一次最长+2
                    if(pre>0){
                        res[index]+=res[pre-1];//如果上一个左括号不在最左边，那么还需加上上一段连续最长的合法括号长度
                    }
                    ret = Math.max(ret, res[index]);//取所有位置的最大值
                }
            }
            index++;
        }
        return ret;
    }
}