/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 */
//(1) 1 2 3 5 8 13
 class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int dp[] = new int[45];
        dp[0] = 1;
        dp[1] = 2;
        int i = 2;
        for (; i < n; i++) 
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[i-1];
    }
}