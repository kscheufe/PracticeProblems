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
        int zeroes = 0;
        zeroes += n / 5;
        zeroes += n/25;
        zeroes += n/125;
        zeroes += n/625;
        zeroes += n/3125;
        return zeroes;
    }
}
/*
class Solution {
    public int trailingZeroes(int n) {
        //0-4 no trailing zeros
        //5-9 has 1
        //10-14 has 2
        //15-19 have 3
        //20 has 4
        //25 has 6 (looking for how many factors of 5 there are)
        //10 000  3125, 625, 125, 25, 5
        int zeroes = 0;
        while (n > 0)
        {
            if (n >= 3125)
            {
                zeroes += 781;
                n -= 3125;
            }
            else if (n >= 625)
            {
                zeroes += 156;
                n -= 625;
            }
            else if (n >= 125)
            {
                zeroes += 31;
                n -= 125;
            }
            else if (n >= 25)
            {
                zeroes += 6;
                n -= 25;
            }
            else if (n >= 5) 
            {
                zeroes += 1;
                n-=5;
            }
            else break;
        }
        return zeroes;
    }
}
 */