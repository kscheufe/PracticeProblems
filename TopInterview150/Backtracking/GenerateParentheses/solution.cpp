class Solution {
    public:
        vector<string> generateParenthesis(int n) {
            vector<string> result;
            string comb;

            backtrack(result, comb, n, 0, 0);
            return result;

        }

        void backtrack(
            vector<string>& result,
            string& comb,
            int n,
            int open,
            int close
        )
        {
            if (n*2 == comb.size())
            {
                result.push_back(comb);
                return;
            }

            if (open < n)
            {
                comb.push_back('(');
                backtrack(result, comb, n, open + 1, close);
                comb.pop_back();
            }

            if (close < open) 
            {
                comb.push_back(')');
                backtrack(result, comb, n, open, close + 1);
                comb.pop_back();
            }
        }
    };