/*
Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder comb = new StringBuilder();

        backtrack(result, comb, n, 0, 0);

        return result;
    }

    void backtrack(List<String> result, StringBuilder comb, int n, int open, int close) {
        if (comb.length() == n*2)
        {
            result.add(comb.toString());
            return;
        }

        if (open < n) {
            comb.append('(');
            backtrack(result, comb, n, open+1, close);
            comb.deleteCharAt(comb.length()-1);
        }

        if (close < open) {
            comb.append(')');
            backtrack(result, comb, n, open, close+1);
            comb.deleteCharAt(comb.length()-1);
        }


    }
}