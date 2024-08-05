class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        unordered_set<int> set;
        int output = 1;
        for (int n : nums) set.insert(n);//add numbers to set
        for (int i : set)
        {
            if (!set.contains(i-1))//start checks only when encountering a new minimum
            {
                int curr = i;
                int counter = 1;
                while (set.contains(curr+1))
                {
                    curr++;
                    counter++;
                }
                output = max(output, counter);
            }
        }
        return output;
    }
};