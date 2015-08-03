   #include <limits>

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int n = prices.size();
        if ( n == 0 ) return 0;

        int max_profit = numeric_limits<int>::min();
        int min_price = numeric_limits<int>::max();

        for ( int i = 0; i < n ; ++i )
        {
            min_price = min(prices[i], min_price);
            max_profit = max(prices[i] - min_price, max_profit);
        }

        return max_profit;
    }
};