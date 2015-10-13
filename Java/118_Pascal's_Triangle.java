public class Solution {
    public List<List<Integer>> generate(int numRows) {
                List<List<Integer>> ans=new ArrayList<List<Integer>>();
    	List<Integer> cur=new ArrayList<Integer>();
    	List<Integer> las;
        for(int i=0;i<numRows;i++){
        	las=cur;
        	cur=new ArrayList<Integer>();
        	if(i==0)
        		cur.add(1);
        	else{
        		for(int j=0;j<=i;j++){
        			if(j==0||j==i)
        				cur.add(1);
        			else{
        				cur.add(las.get(j)+las.get(j-1));
        			}
        		}
        	}
        	ans.add(cur);
        }
        return ans;
    }
}