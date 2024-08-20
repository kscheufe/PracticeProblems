class Solution {
public:
    //faster solution
    int calculate(string s) {
        int sum = 0;
        stack<pair<int, int>> st;
        int sign = 1;
        //for each char
        for (int i = 0; i < s.size(); i++) 
        {
            if (isdigit(s[i])) 
            {
                int64_t num = 0;
                while (i < s.size() && isdigit(s[i]))
                {
                    num = num *10 + s[i]-'0';
                    i++;
                }
                i--;//revert one ++ from the while loop checking order
                sum += num * sign;
                sign = 1;//reset sign
            }
            else if (s[i] == '(')
            {
                st.push({sum, sign});//really, can't a negative value be pushed to a set?
                sum = 0;
                sign = 1;
            }
            else if (s[i] == ')')
            {
                sum = st.top().first + st.top().second * sum;
                st.pop();
            }
            else if (s[i] == '-')
            {
                sign = -sign;
            }
        }
        return sum;
    }

    /* //my solution from java
    int calculate(string s) {
        stack<string> st;
        string current = "";
        string ans = "";
        s+= ")";//auto trigger a solve at the end

        for (char c : s)
        {
            if (c == ' ')
                continue;//skip spaces
            else if (c=='(')
            {
                st.push(current);//push the current expression to the stack for later
                current = "";
            }
            else if (c == ')')
            {
                //evaluate current, and return it as a string
                ans = evaluate(current);
                cout << current << "= " << ans << ", ";

                if (!st.empty())
                {
                    if (ans == "0")
                    {
                        //remove ans and the operator before it
                        current = st.top();
                        st.pop();
                        if (current.length() > 0) {
                            current = current.substr(0, current.length()-1);

                        }
                    }
                    else {
                        current = st.top() + ans;//concat answer to current
                        st.pop();
                    }
                }
                //else (if st is empty)
                else return stoi(ans);
            }
            else current += c;//concat c to current
        }
        return 0;//should never occur, given question parameters
    }
    string evaluate(string express)
    {
        string expression = express + ")";//auto trigger a solve
        //pre-append a 0 if starting with a -
        if (expression[0] == '-') expression = '0' + expression;
        int operand1 = 0; int operand2 = 0;
        char operation = 'p';//placeholder value
        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression[i];
            if (c == '+' || c == '-' || c == ')')
            {
                //(num) submitted
                if (operation == 'p' && c == ')')
                {
                    return express;//original
                }
                else if (operation == 'p')
                    operation = c;//store the first operation
                else if (operation == '+')
                {
                    operand1 = operand1 + operand2;
                    operand2 = 0;
                    operation = c;
                }
                else if (operation == '-')
                {
                    operand1 = operand1-operand2;
                    operand2 = 0;
                    operation = c;
                    if (c == '-' && expression[i-1] == '-')
                    {//double neg
                        operation = '+';
                    }
                }
                if (c == ')') return to_string(operand1);
            }
            else if (operation == 'p')
            {
                operand1*=10;
                operand1+= c-'0';
            }
            else {
                operand2*=10;
                operand2+=c-'0';
            }
        }
        return "";//should never be reached
    }
    */
};