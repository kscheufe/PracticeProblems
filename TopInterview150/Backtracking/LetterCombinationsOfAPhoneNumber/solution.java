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
        List<String> result = new ArrayList<>();
        if (digits.length()==0 || digits=="") return result;
        Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
        recurse(digits, 0, new StringBuilder(), result, map);
        return result;

    }

    public void recurse(String digits, int index, StringBuilder comb, List<String> result, Map<Character, String> map) {
        if (index == digits.length()) {//base case, when max depth has been reached
            result.add(comb.toString());
            return;
        }     
        
        //convert string of letters for current number to a character array
        char[] letters = map.get(digits.charAt(index)).toCharArray();

        for (char c: letters) {
            comb.append(c);//add current character
            recurse(digits, index + 1, comb, result, map);//recurse to next level
            comb.deleteCharAt(comb.length()-1);//delete most recent char from string for next option
        }
    }

    // public List<String> letterCombinations(String digits) {
    //     if (digits.length() == 0) return new ArrayList<>();

    //     List<String> ret = new ArrayList<>();
    //     Map<Character, String> map = new HashMap<>();
    //     Queue<String> queue = new LinkedList<>();
    //     queue.offer("");
    //     map.put('2', "abc");
    //     map.put('3', "def");
    //     map.put('4', "ghi");
    //     map.put('5', "jkl");
    //     map.put('6', "mno");
    //     map.put('7', "pqrs");
    //     map.put('8', "tuv");
    //     map.put('9', "wxyz");


    //     for (int i = 0; i < digits.length(); i++)
    //     {
    //         String newDigits = map.get(digits.charAt(i));
    //         while (queue.peek().length() == i)
    //         {
    //             String oldString = queue.poll();
    //             for (int j = 0; j < newDigits.length(); j++)
    //             {
    //                 queue.offer(oldString + newDigits.charAt(j));
    //             }
    //         }
    //     }

    //     while (queue.peek() != null) ret.add(queue.poll());
    //     return ret;
    // }
}
