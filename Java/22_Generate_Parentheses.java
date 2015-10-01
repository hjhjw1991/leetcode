public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>();
        genNextParenthesis(n, 0, "", all);
        return all;
    }
    
    public void genNextParenthesis(int n, int open, String parent, List<String> all){
        if(n<1){
            while(open>0){
                parent+=")";
                open--;
            }
            all.add(parent);
            return;
        }else{
            genNextParenthesis(n-1, open+1, parent+"(", all);
            if(open>0){
                genNextParenthesis(n, open-1, parent+")", all);
            }
        }
    }
}