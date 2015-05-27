public class Solution {
    public String reverseWords(String s) {
        	if(s.length()<=1)
    		return s.equals(" ")?"":s;
    	StringBuffer tr = new StringBuffer();
    	StringBuffer re = new StringBuffer();
    	for(int i=s.length()-1;i>=0;i--){
    		if(s.charAt(i)!=' '){
    			tr.append(s.charAt(i));
    			if(i>0 && s.charAt(i-1) == ' '){
    				re.append(tr.reverse());
    				re.append(' ');
    				tr.setLength(0);
    			}
    			else if(i<=0){
    				re.append(tr.reverse());
    			}
    		}
    	}
    	if(re.length()>1 && re.charAt(re.length()-1) == ' ')
    		re.deleteCharAt(re.length()-1);
        return re.toString();
    }
}