import java.util.*;
import dutil.*;

public class Solution extends Test {
    private static Solution so;
    protected void solve(Scanner sc){
        String num = sc.next();
        int target = sc.nextInt();
        Print.print(num);
        Print.print(target);
        Print.printList(so.addOperators(num, target));
    }
    
    public List<String> addOperators(String num, int target){
        List<String> res = new ArrayList<String>();
        if(num==null||num.length()<1){
            return res;
        }
        for(int i=1;i<=num.length();i++){
            String preexp = num.substring(0, i);
            long prevalue = Long.valueOf(preexp);
            if(!String.valueOf(prevalue).equals(preexp))continue;//why this?
            tryOperator(num, target, preexp, i, '#', prevalue, prevalue, res);
            
        }
        return res;
    }
    
    public void tryOperator(String num, int target, String preexp, int curposition, char preoperator, long curvalue, long preoperand, List<String> res){
        if(curposition==num.length() && curvalue==target){
            res.add(preexp);
            return;
        }
        for(int i=curposition+1;i<=num.length();i++){
            String curnums = num.substring(curposition, i);
            long curnum = Long.valueOf(curnums);
            if(!String.valueOf(curnum).equals(curnums))continue;//why this?
            tryOperator(num, target, preexp+'+'+curnums, i, '+', curvalue+curnum, curnum, res);
            tryOperator(num, target, preexp+'-'+curnums, i, '-', curvalue-curnum, curnum, res);
            tryOperator(num, target, preexp+'*'+curnums, i, preoperator, (preoperator=='-')?curvalue+preoperand-preoperand*curnum:((preoperator=='+')?curvalue-preoperand+preoperand*curnum:preoperand*curnum), preoperand*curnum, res);// if is - or +, make up last operand, or passing the multiplication. the hardest part of handling expression
        }
    }
    
    public static void main(String argv[]){
        file="test";
        so = new Solution();
        if(!DEBUG){
            try{
                redirectStream();
            }catch(Exception e){
                return;
            }
        }
        
        // below is related to concrete problems
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            so.solve(sc);
        }
    }
}