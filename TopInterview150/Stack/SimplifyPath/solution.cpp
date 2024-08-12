class Solution {
public:
    string simplifyPath(string path) {
        stack<string> stack;
        string output = "";
        string current = "";
        path = path + "/";
        for (char c : path)
        {
            if (c == '/')
            {
                if (current == "..")
                { 
                    if (!stack.empty()) 
                    {
                        stack.pop();
                    }
                }
                else if (current == ".")
                    ;
                else if (current == "")
                    continue;
                else stack.push(current);
                current = "";
            }
            else current += c;
        }
        while (!stack.empty())
        {
            output = "/" + stack.top() + output;
            stack.pop();
        }
        if (output == "") return "/";
        return output;
    }
};