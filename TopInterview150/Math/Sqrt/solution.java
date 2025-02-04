/*
Given a non-negative integer x, return the square root of x rounded down 
to the nearest integer. The returned integer should be non-negative as 
well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it 
down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 2^31 - 1
 */
class Solution {
    public int mySqrt(int x) {
        if (x==0 || x == 1) return x;
        //2^16 is highest integer (sqrt(2^32))
        int right = x;
        int left = 1;
        int mid;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if ((long) mid * mid > (long) x)
            {
                right = mid - 1;
            }
            else if (mid * mid == x) return mid;
            else 
                left = mid + 1;
        }
        return Math.round(right);
    }
}
/*
1 2 3 4  5  6  7  8  9  10
1 4 9 16 25 36 49 64 81 100
x = 8
mid = 5
 */