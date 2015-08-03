class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> ans;
        ans.push_back(1);
        if(rowIndex==0)return ans;
        if(rowIndex==1){
            ans.push_back(1);
            return ans;
        }
        vector<int> cur=getRow(rowIndex-1);
        for(int j = 1;j < rowIndex;j++)
        {
              ans.push_back(cur[j] + cur[j - 1]);
        }
        ans.push_back(1);
        
        return ans;
    }
};