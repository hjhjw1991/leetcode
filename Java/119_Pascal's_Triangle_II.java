public class Solution {
    // 2 ms
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex<=0)return res;
        List<Integer> pre = getRow(rowIndex-1);
        int p = pre.get(0), q;
        for(int i=1;i<pre.size();i++){
            q=pre.get(i);
            res.add(p+q);
            p=q;
        }
        res.add(1);
        return res;
    }
}