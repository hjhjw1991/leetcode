import java.util.*;
import dutil.*;

public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0){
            return path;
        }
        int length = path.length();
        LinkedList<String> pat = new LinkedList<String>();
        int i=0, end;
        while(i<length){
            end = i+1;
            while(end<length && path.charAt(end)!='/')end++;
            String sub = path.substring(i+1, end);
            if(sub.length()>0){
                if(sub.equals("..")){// every ".." means an upper level path
                    if(pat.size()>0){
                        pat.pollLast();
                    }
                }else if(!sub.equals(".")){// every "." means a current level path, which has no effect
                    pat.add(sub);
                }
            }
            i=end;
        }
        if(pat.size()==0)return "/";
        StringBuffer sb = new StringBuffer();
        for(String str:pat){
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        Print p=new Print();
        String[] cases = {
            "/home/",
            "/../",
            "/a/./b/../../c/",
            "/home//c//"
        };
        for(String path:cases){
            p.print(so.simplifyPath(path));
        }
    }
}