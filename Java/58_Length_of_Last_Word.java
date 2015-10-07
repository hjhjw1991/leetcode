public class Solution {
    // 这是个Easy的题，要求简单，测例也简单，但是可以提示我们处理字符串、单词和文本的时候需要考虑哪些问题，比如：
    // 是否空串？是否有超长输入？
    // 是否含有特殊字符，例如非ASCII符号或控制符？
    // 是否含有多余的空格？
    // 文本是否符合正确句子格式？例如，是否含有连续的... ,,, ???这种符号？
    // 是先转换成字符串数组处理更方便省时，还是直接利用String的charAt和substring方法处理更方便省时？
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0)return 0;
        char[] str = s.toCharArray();
        int res = 0, i=str.length-1;
        while(i>=0&&str[i]==' '){
            i--;
        }
        while(i>=0&&str[i]!=' '){
            i--;
            res++;
        }
        return res;
    }
}