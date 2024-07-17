/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;
        while (p2>p1)
        {
            if (Character.toLowerCase(s.charAt(p2)) == Character.toLowerCase(s.charAt(p1)))
            {
                p1++;
                p2--;
            }
            else if (!Character.isLetterOrDigit(s.charAt(p1)))
            p1++;
            else if (!Character.isLetterOrDigit(s.charAt(p2)))
            p2--;
            else return false;
        }

        return true;
    }
}