/*
Given a string containing digits from 2-9 inclusive, return all possible 
letter combinations that the number could represent. Return the answer in 
any order.

A mapping of digits to letters (just like on the telephone buttons) is 
given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        List<String> ret = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        for (int i = 0; i < digits.length(); i++)
        {
            String newDigits = map.get(digits.charAt(i));
            while (queue.peek().length() == i)
            {
                String oldString = queue.poll();
                for (int j = 0; j < newDigits.length(); j++)
                {
                    queue.offer(oldString + newDigits.charAt(j));
                }
            }
        }

        while (queue.peek() != null) ret.add(queue.poll());
        return ret;
    }
}
