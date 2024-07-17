/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

//so simple
class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < cost)//if there's a new lowest cost
            {
                cost = prices[i];//update it
            }
            else if (prices[i]-cost > profit)//if the current profit is better
            {
                profit = prices[i] - cost;//update
            }
        }
        return profit;
    }
}

//finally works, but uses way more time and way less memory than most people, let's see what the usual solution is
class Solution {
    public int maxProfit(int[] prices) {
        int highest = 0;
        int highestIndex = 0;
        int leftmostIndex = 0;
        int lowest = 10001;
        int value = 0;
        while (leftmostIndex != prices.length-1)   //break condition when all of array has been checked
        {
            //find the local maximum
            for (int i = highestIndex + 1; i < prices.length; i++)
            {
                if (prices[i]>=highest)  
                {
                    highest=prices[i];
                    highestIndex = i;
                }
            }
            //find the local minimum to the left of maximum
            for (int i = leftmostIndex; i < highestIndex; i++)
            {
                if (prices[i] < lowest)
                {
                    lowest = prices[i];
                }
            }
            //calculate sale value and replace if appropriate
            if (highest-lowest > value)
            {
                value = highest-lowest;
            }
            System.out.println(leftmostIndex + ", " + highestIndex);
            //update leftmostIndex to now check the remaining elements to the right of highestindex
            leftmostIndex = highestIndex;
            //reset highest and lowest value
            highest = 0;
            lowest = 10001;
            
        }
        //return the best sale value
        return value;
    }
}

//only 2 tests failed on time here, closest yet
/*
class Solution {
    public int maxProfit(int[] prices) {
        int highest = 0;
        int lowest = 10001;
        int value = 0;
        for (int i = 0; i < prices.length; i++)
        {
            //find next local minimum
            if(prices[i] < lowest)
            {
                lowest = prices[i];
            }
            else //prices[i] > lowest indicates the last element was the local minimum
            {
                //for remaining elements, find global maximum 
                //(only if previously used maximum has been passed by array index i)
                if (highest == 0)
                {
                    highest = 0;//reset highest to find the next maximum
                    for (int j = i; j < prices.length; j++)
                    {
                        if (prices[j] > highest)
                        {
                            highest = prices[j];
                        }
                    }
                }
                //if this difference is greater than current profit value, overwrite it
                if (highest-lowest > value)
                {
                    value = highest-lowest;
                }
                //reset lowest to find next local minimum, global maximum
                lowest = 10001;
            }
            //if highest is passed in the array, find the next one 
            //(handles duplicate highest's too)
            if (prices[i] == highest)
            {
                highest = 0;
            }
        }
        return value;
    }
}
 */



//still works but too slow, but passed more than the first solution (at bottom of page)
/*
class Solution {
    public int maxProfit(int[] prices) {
        //find next local minimum
        //then find global maximum after that minimum
        //update value if appropriate
        int value = 0;
        int lowest = 10001;//higher than the higest value allowed
        int highest = 0;
        for (int i = 0; i < prices.length; i++)
        {
            //find next local minimum
            if(prices[i] < lowest)
            {
                lowest = prices[i];
            }
            else //prices[i] > lowest indicates the last element was the local minimum
            {
                //for remaining elements, find global maximum
                for (int j = i; j < prices.length; j++)
                {
                    if (prices[j] > highest)
                    {
                        highest = prices[j];
                    }
                }
                //if this difference is greater than current profit value, overwrite it
                if (highest-lowest > value)
                {
                    value = highest-lowest;
                }
                //reset values to find next local minimum, global maximum
                lowest = 10001;
                highest = 0;
            }
        }

        return value;
    }
}
 */



//solution below works but too slow (nlogn time)
/*
class Solution {
    public int maxProfit(int[] prices) {
        //iterate through the array
        int lowest = 0;
        int value = 0;
        for (int i = 0; i < prices.length; i++)
        {
            lowest = prices[i];
            for (int j = i; j < prices.length; j++)
            {
                if (prices[j] > lowest && prices[j]-lowest > value)
                {
                    value = prices[j]-lowest;
                }
            }
        }
        return value;
    }
}
 */