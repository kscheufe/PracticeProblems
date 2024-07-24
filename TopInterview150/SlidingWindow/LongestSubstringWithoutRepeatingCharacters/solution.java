/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces
 */

 //move p2 by default
 //move p1 whenever a duplicate character is found
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int p1 = 0;
        int longestLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        for (int p2 = 0; p2 < s.length(); p2++) {
            while (set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
            }
            set.add(s.charAt(p2));
            longestLength = Math.max(longestLength, p2 - p1 + 1);
        }
        
        return longestLength;
    }
};