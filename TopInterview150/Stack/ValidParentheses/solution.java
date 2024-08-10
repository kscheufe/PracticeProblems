/*
Given a string s containing just the characters '(', ')', '{', '}', '[' 
and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.
 */


 class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray())
        {
            if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
 }
 /*
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (stack.isEmpty())
            {
                return false;
            }
            else
            {
                char curr = stack.peek();
                switch (curr)
                {
                    case '(':
                        if (s.charAt(i) == ')') stack.pop();
                        else return false;
                        break;
                    case '{':
                        if (s.charAt(i) == '}') stack.pop();
                        else return false;
                        break;
                    case '[':
                        if (s.charAt(i) == ']') stack.pop();
                        else return false;
                        break;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
     */