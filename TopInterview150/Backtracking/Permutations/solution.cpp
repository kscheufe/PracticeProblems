class Solution {
    public:
        vector<vector<int>> permute(vector<int>& nums) {
            vector<vector<int>> result;
            vector<int> comb;
            
            backtrack(result, comb, nums);
            return result;
        }

        void backtrack(
            vector<vector<int>>& result, 
            vector<int>& comb, 
            vector<int> nums
        )
        {
            if (comb.size() == nums.size())
            {
                result.push_back(comb);
                return;
            }

            for (int i : nums)
            {
                if (find(comb.begin(), comb.end(), i) != comb.end()) continue;

                comb.push_back(i);
                backtrack(result, comb, nums);
                comb.pop_back();
            }
        }
    };