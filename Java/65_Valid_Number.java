import java.util.regex.Matcher;
import java.util.regex.Pattern;
//TODO try to use finite state machine
public class Solution {
    public boolean isNumber(String s) {
        String regex =  "^(\\s*)([\\-+])?((\\d+(\\.\\d*)?)|(\\.\\d+))(e([\\-+])?\\d+)?(\\s*)$";
    	Pattern p = Pattern.compile(regex);
    	Matcher m=p.matcher(s);
    	return m.matches();
    }
}