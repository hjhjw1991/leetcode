public class Solution {
    // 9ms
    // 从最下一层到最上一层，动态规划
    // 每一个格子的最小代价是其左右子格子的最小代价加上当前代价
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)return 0;
        if(triangle.size()==1)return triangle.get(0).get(0);
        List<Integer> cur = triangle.get(triangle.size()-1), below;
        int c;
        for(int i=triangle.size()-2;i>=0;i--){
            below = cur;
            cur = triangle.get(i);
            for(int j=0;j<cur.size();j++){
                c=cur.get(j);
                cur.set(j, Math.min(below.get(j),below.get(j+1))+c);
            }
        }
        return cur.get(0);
    }
}