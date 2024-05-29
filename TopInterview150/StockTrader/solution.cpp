/*
//keeping lowest cost, 
//iterate through once
//if there's a new lowest cost, update it
//if there's a new highest profit, update it
//return
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int lowest = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.size(); i++)
        {
            if (lowest > prices[i])
            {
                lowest = prices[i];
            }
            else if (profit < prices[i]-lowest)
            {
                profit = prices[i]-lowest;
            }
        }
        return profit;
    }
};
