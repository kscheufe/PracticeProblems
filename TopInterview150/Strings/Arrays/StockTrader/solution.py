"""

//keeping lowest cost, 
//iterate through once
//if there's a new lowest cost, update it
//if there's a new highest profit, update it
//return

"""

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        lowest = 10001
        profit = 0
        for x in range(len(prices)):
            if prices[x] < lowest:
                lowest = prices[x]
            if profit < prices[x] - lowest:
                profit = prices[x]-lowest
        return profit
