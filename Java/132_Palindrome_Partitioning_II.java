public class Solution {
    public int minCut(String s) {
        if(s==null||s.length()<=1)return 0;
        int len=s.length();
        String rev = new StringBuffer(s).reverse().toString();
        for(int i=1;i<len-1;i++){
            if(s.substring(0,i).equals(rev.substring(len-1-i))&&s.substring(i).equals(rev.substring(0, len-1-i))){
                return 1;
            }
        }
        char[] str = s.toCharArray();
        boolean[][] isParam = new boolean[len+1][len+1];// 记录从i到j是否回文,默认值false
        int min=len;
        int[] mins = new int[len];// 记录到位置i为止最小的分割数
        // 初始化最小分割数为字母数-1
        for(int i=0;i<len;i++){
            mins[i]=i;
        }
        for(int i=0;i<len;i++){// 以i为结尾的字符串，往i左方扫描，每发现一个回文则更新一次切割，最终mins[i]保存i位置最小的切割
            for(int j=i;j>=0;j--){
                if(str[i]==str[j]&&((i-j<2) || isParam[j+1][i-1])){
                    isParam[j][i]=true;
                    mins[i]=Math.min(mins[i], j>0?mins[j-1]+1:0);// 如果j大于0，则加上mins[j-1]的切割数，及本次切割，否则切割数为0
                }
            }
        }
        return mins[len-1];
    }
}