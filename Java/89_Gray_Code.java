//bit manipulation
public class Solution {
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> ret=new LinkedList<Integer>();
        ret.add(0);
        if(n<1){
            return ret;
        }
        for(int i=1;i<(1<<n);i++){
            ret.add(ret.peekLast()^(i&-i));//i&-i gets the most right 1 of i
        }
        return ret;
    }
}