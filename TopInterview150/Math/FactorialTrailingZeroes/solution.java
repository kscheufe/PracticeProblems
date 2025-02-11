/*
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 10^4
 
Follow up: Could you write a solution that works in logarithmic time 
complexity?

 */
class Solution {
    public int trailingZeroes(int n) {
        //0-4 no trailing zeros
        //5-9 has 1
        //10-14 has 2
        //15-19 have 3
        //20- have 4
        for (int i = 10; i > -1; i--)
        {
            System.out.println(factorial(i));
        }
    }
    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}