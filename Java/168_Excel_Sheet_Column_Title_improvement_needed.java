public class Solution {
    String b[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public String convertToTitle(int n) {
        if(n <= 0)return null;
        StringBuffer s = new StringBuffer();
		int r;
		while(n>0){
			n--;
			r=n%26;
			n=n/26;
			s.append(b[r]);
		}
		return s.reverse().toString();
    }
}