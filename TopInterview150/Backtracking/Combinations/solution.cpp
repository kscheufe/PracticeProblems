class Solution {
    public:
        vector<vector<int>> combine(int n, int k) {
            vector<vector<int>> result;
            vector<int> comb;

            backtrack(result, comb, n, k, 1);
            return result;
        }

        void backtrack(
            vector<vector<int>>& result,
            vector<int>& comb, 
            //pass by reference &s go in the function definition, not in the invocation
            int n, 
            int k, 
            int start
        )
        {
            if (comb.size() == k)
            {
                result.push_back(comb);
                return;
            }

            for (int i = start; i <= n; i++)
            {
                comb.push_back(i);
                backtrack(result, comb, n, k, i+1);
                comb.pop_back();
            }
        }
    };