public class Solution {
    public int evalRPN(String[] tokens) {
        int result=0;
    	if(tokens.length<1||tokens[0].equals(""))return -1;
    	if(tokens.length==1)return Integer.parseInt(tokens[0]);
    	ArrayList<Integer> operand = new ArrayList<Integer>();
    	for(String str:tokens){
    		int i=operand.size();
    		if(!(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))){
				operand.add(Integer.parseInt(str));
    		}else if(i>1){
    			int b = operand.remove(i-1);
    			int a = operand.remove(i-2);
    			if(str.equals("+"))result = a + b;
    			if(str.equals("-"))result = a - b;
    			if(str.equals("*"))result = a * b;
    			if(str.equals("/")&&b!=0)result = a / b;
    			operand.add((result));
    		}else{
    		}
    	}
    	return result;
    }
}