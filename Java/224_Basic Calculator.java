public class Solution{
    public int calculate(String s){
        s=s.replaceAll(" ","");
        s=s+"\"";
        char[] exp=s.toCharArray();
        int length = exp.length;
        char[] ops=new char[length];
        int[] nus=new int[length];
        int co=-1,cn=-1,cur=-1,n=0;
        char c,o;
        ops[++co]='"';
        while(cur<length-1){
            c=exp[++cur];
            switch(c){
                case '+':
                case '-':
                    if(ops[co]=='('||ops[co]=='"'){
                        ops[++co]=c;
                    }else{
                        n=cal(ops[co--], nus[cn-1], nus[cn]);
                        nus[--cn]=n;
                        cur--;
                    }
                    break;
                case '*':
                case '/':
                case '(':
                    ops[++co]=c;
                    break;
                case ')':
                    while(ops[co]!='('){
                        n=cal(ops[co--], nus[cn-1], nus[cn]);
                        nus[--cn]=n;
                    }
                    co--;
                    break;
                case '"':
                    while(ops[co]!='"'){
                        n=cal(ops[co--], nus[cn-1], nus[cn]);
                        nus[--cn]=n;
                    }
                    break;
                default:
                    n=0;
                    while(c<='9'&&c>='0'){
                        n *= 10;
                        n += c-'0';
                        c=exp[++cur];
                    }
                    nus[++cn]=n;
                    --cur;
            }
        }
        return nus[cn];
    }
    public int cal(char op, int e1, int e2){
        int res=0;
        switch(op){
            case '+':
                res=e1+e2;
                break;
            case '-':
                res=e1-e2;
                break;
            case '*':
                res=e1*e2;
                break;
            case '/':
                if(e2!=0){
                    res=e1/e2;
                }
                break;
        }
        return res;
    }
    
    public static void main(String[] args){
        Solution sl=new Solution();
        String[] exp={
            "1 + 2*(3-4)",
            "(1+(4+5+2)-3)+(6+8)",
            "10",
            };
        for(String s:exp){
            System.out.println(sl.calculate(s));
        }
    }
}