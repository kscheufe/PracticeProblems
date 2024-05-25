#include<list>
#include<vector>
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int counter = 0;
        int value = 0;
        std::set<int> blacklist;
        for (int i=0;i<nums.size(); i++)
        {
            counter = 1;
            value = nums[i];
            auto it1 = blacklist.find(value);
            if (it1 == blacklist.end())
            {
                for (int j =0; j < nums.size(); j++)
                {
                    if (nums[i] == nums[j])
                    { counter++; }
                    else counter--;
                }
                if (counter > 0)
                {
                    return value;
                }
                blacklist.insert(value);
            }
        }
        return 0;//unreachable from problem definition
    }
};

//adding the blacklist set cut the function from 2338ms to 19ms