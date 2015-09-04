import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
        if(words.length==0){
            return ret;
        }
        justify(words, 0, maxWidth, ret);
        return ret;
    }
    
    public void justify(String[] words, int start, int maxWidth, List<String> pre){
        if(start>=words.length){
            return;
        }
        int length=words[start].length(),end=start+1;
        while(end<words.length){// get words of current line
            if(length+words[end].length()+1<=maxWidth){
                length += words[end].length()+1;
                end++;
            }else{
                break;
            }
        }
        int num = end - start - 1;
        StringBuffer sb = new StringBuffer(words[start]);
        if(end<words.length){// not the last line
            if(num>=1){
                int extra = 0;// greedy. extra means extra spaces that can be inserted into every words of the current line
                while(length + num * (extra + 1)<=maxWidth){
                    extra++;
                }
                int ee=maxWidth - length - num*extra;
                for(int i=start+1;i<end;i++){
                    for(int j=0;j<=extra;j++){
                        sb.append(" ");
                    }
                    if(ee>0){
                        sb.append(" ");
                        ee--;
                    }
                    sb.append(words[i]);
                }
            }else{
                for(int i=0;i<maxWidth - length;i++){
                    sb.append(" ");
                }
            }
            pre.add(sb.toString());
            justify(words, end, maxWidth, pre);
        }else{// deal with the last line
            if(num>=1){
                for(int i=start+1;i<end;i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            for(int i=0;i<maxWidth - length;i++){
                sb.append(" ");
            }
            pre.add(sb.toString());
            return;
        }
    }
    
    public static void main(String argv[]){
        String[] words = {
            "What","must","be","shall","be."
            };
        Solution so=new Solution();
        int maxWidth = 12;
        int[] format = new int[maxWidth];
        for(int i=0;i<maxWidth;i++){
            format[i]=i%10;
        }
        print(format,"");
        print(so.fullJustify(words, maxWidth));
    }
    
    static void print(List<String> list){
        for(String s:list){
            print(s);
        }
    }
    static void print(int[] num, String delimiter){
        if(delimiter==null)delimiter="\t";
        for(int n:num){
            System.out.print(n);
            System.out.print(delimiter);
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
    
    static void print(String str){
        System.out.println(str);
    }
}