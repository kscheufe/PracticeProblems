class Solution {
    public:
        vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            vector<vector<int>> result;
            vector<int> comb;

            backtrack(result, comb, candidates, target, 0);
            return result;
        }
        void backtrack(
            vector<vector<int>>& result,
            vector<int>& comb,
            vector<int>& candidates,
            int target,
            int start
        ) {
            if (target == 0)
            {
                result.push_back(comb);
                return;
            }

            for (int i = start; i < candidates.size(); i++)
            {
                if (candidates[i] <= target)
                {
                    comb.push_back(candidates[i]);
                    backtrack(result, comb, candidates, target - candidates[i], i);
                    comb.pop_back();
                }
            }
        }

    };