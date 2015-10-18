public class Solution {
    public List<List<String>> partition(String s) {
        //找到从0开始的回文子串，分别为切割点，与后面的回文分割相组合
        //后面至少存在一种切割，是所有字符都分开，如果返回了空，则说明前面的切割已经到结尾
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null||s.length()==0)return  res;
        List<Integer> pre = new LinkedList<>();
        for(int i=1;i<=s.length();i++){
            if(isPalind(s.substring(0, i)))pre.add(i);// 只存储回文子串的下标而不是值
        }
        for(int i:pre){
            //递归的方式解，相当暴力
            List<List<String>> rs=partition(s.substring(i));
            if(rs.size()>0){
                for(List<String> r:rs){
                    List<String> pree = new LinkedList<>();
                    pree.add(s.substring(0,i));
                    pree.addAll(r);
                    res.add(pree);
                }
            }else{
                 List<String> pree = new LinkedList<>();
                 pree.add(s.substring(0,i));
                 res.add(pree);
            }
        }
        return res;
    }
    public boolean isPalind(String s){
        int len=s.length();
        if(len==1)return true;
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-1-i))return false;
        }
        return true;
    }
}