public class Solution {
    public int titleToNumber(String s) {
        int res=0;
        if(s.length()<=0)return res;
        int[] map=new int[91];
        for(int j=1,i=65;i<=90;i++,j++){
        	map[i]=j;
        }
        for(int i=0;i<s.length();i++){
        	res*=26;
        	char cur=s.charAt(i);
        	res+=map[(int)cur];
        }
        return res;
    }
}