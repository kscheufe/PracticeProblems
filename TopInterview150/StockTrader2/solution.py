
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        profit = 0
        for x in range(len(prices)-1):
            if prices[x+1] > prices[x]:
                profit += prices[x+1] - prices[x]

        return profit