/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters
 */

 //this method is technically slower than the fastest one for the given test cases, but actually has better time complexity
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int shortestLength = strs[0].length();//initialize to first length
        String longestPrefix = strs[0];
        //String currentLetter = strs[0][0];
        for (int i = 1; i < strs.length; i++)//check all strings
        {
            if (strs[i].length() < shortestLength)
            {
                shortestLength = strs[i].length();
                longestPrefix = longestPrefix.substring(0, shortestLength);
            }
            for (int j = 0; j < shortestLength; j++)//check the first x characters of each string (x == shortestlength so far)
            {    
                if (shortestLength == 0)//early return 0 without executing pointless comparisons
                {
                    return "";
                }
                if (strs[i].charAt(j) != longestPrefix.charAt(j))//if there is a character mismatch
                {
                    shortestLength = j;
                    longestPrefix = strs[0].substring(0, j);
                }
            }
        }
        return longestPrefix;
    }
}
