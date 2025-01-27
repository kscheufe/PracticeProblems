/*
Given a string s representing a valid expression, implement a basic 
calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates 
strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */
class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        String current = "";
        String ans = "";
        s += ")";//to auto trigger a solve at the end???
        for (char c : s.toCharArray())
        {
            if (c == ' ')
                continue;
            else if (c == '(')
            {
                st.push(current);
                current = "";
            }
            else if (c == ')')
            {
                //evaluate current, and return it as a string
                ans = evaluate(current);
                System.out.println(current);
                System.out.println(ans);
                //if a prev current exists
                if (!st.isEmpty())
                {
                    if (ans == "0")//if result of an enclosed bracket is 0, remove it and the operator before it
                    { 
                        current = st.pop();
                        if (current.length() > 0) {
                            current = current.substring(0, current.length()-1);
                        }
                    }
                    else {
                        //get the previous current and concat answer to it
                        current = st.pop() + ans;
                   }
                }
                //otherwise return the answer
                else return Integer.parseInt(ans);
            }
            else current += c;
        }
        return 0;//should never be reached
    }
    public String evaluate(String express)
    {
        String expression = express + ")";
        if (expression.charAt(0) == '-') expression = '0' + expression;
        char[] charArray = expression.toCharArray();
        int operand1 = 0;
        int operand2 = 0;
        char operation = 'p';//placeholder, cannot be empty
        for (int i = 0; i < charArray.length; i++)
        {
            char c = charArray[i];
            if (c == '+' || c == '-' || c == ')')
            {
                if (operation == 'p' && c == ')')//(num) submitted
                {
                    return express;//return original
                }
                else if (operation == 'p')
                    operation = c;//store the first operation
                else if (operation == '+')
                {
                    operand1 = operand1+operand2;
                    operand2 = 0;
                    operation = c;
                }
                else if (operation == '-')
                {
                    /*
                    if (operand2 == 0)//no number encountered yet (double expression signs)
                    {
                        if (operation == c) {operation = '+';}
                        else operation = '-';
                        continue;
                    }// */
                    
                    operand1 = operand1-operand2;
                    operand2 = 0;
                    operation = c;
                    if (c == '-' && charArray[i-1] == '-')
                    {
                        operation = '+';      
                    }
                }
                if (c == ')') return "" + operand1;
            }
            else if (operation == 'p')
            {
                operand1 *= 10;
                operand1 += Character.getNumericValue(c);
            }
            else {
                operand2 *= 10;
                operand2 += Character.getNumericValue(c);
            }
        }
        return "";//should never be reached
    }
}