class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        int operand1;
        int operand2;
        for (string token : tokens)
        {
            if (token == "*" || token == "/" || token == "+" || token == "-")
            {
                operand2 = st.top();
                st.pop();
                operand1 = st.top(); st.pop();
                if (token == "/")
                    st.push(operand1/operand2);
                else if (token == "*")
                    st.push(operand1*operand2);
                else if (token == "-")
                    st.push(operand1-operand2);
                else
                    st.push(operand1+operand2);
            }
            else st.push(stoi(token));
        }
        return st.top();
    }
};