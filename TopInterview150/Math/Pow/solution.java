/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;//handle base case

        long exp = n;
        if (exp < 0) {//handle negative
            x = 1/x;
            exp *= -1;
        }

        double result = 1.0;//handle regular function using binary exponentiation
        while (exp > 0) {
            if (exp % 2 == 1)//if exp becomes odd during division, (decimals will be dropped thanks to long/integer division)
            {
                result *= x;//multiply current binary exponent (1, 2, 4, 8, ...)
            }
            x *= x;//exponentially reduce exponent by squaring base
            exp /= 2;//halve base
        }

        return result;
    }
}

/* slower solution, first pass
class Solution {
    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (x==-1) {
            if (n % 2 == 0) return 1;
            return -1;
        }
        double base = x;
        if (n == 0) return 1.0;
        if (n < 0) {
            base = 1.0/base;
            x = base;
            n *= -1.0;
        }
        for (int i = 1; i < n; i++) {
            base *= x;
            if (Math.abs(base) < 0.000005) return base;
        }
        return base;
    }
}
 */