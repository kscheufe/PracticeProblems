class Solution {
    public:
        vector<int> searchRange(vector<int>& nums, int target) {
            int l = 0;
            int r = nums.size()-1;
            vector<int> output = {-1, -1};
            if (nums.size() == 0) return output;

            while (l <= r)
            {
                int index = l + (r-l)/2;

                if (nums[index] == target)
                {
                    if (index==0 || nums[index-1] != target)
                    {
                        output[0] = index;
                        break;
                    }
                    else {
                        r = index-1;
                        continue;
                    }
                }

                else if (nums[index] < target) {
                    l = index+1;
                }

                else r = index-1;
            }

            if (output[0] == -1) return output;
            l = output[0];
            r = nums.size()-1;

            while (l <= r)
            {
                int index = l + (r-l)/2;

                if (nums[index] == target)
                {
                    if (index==nums.size()-1 || nums[index+1] != target)
                    {
                        output[1] = index;
                        break;
                    }
                    else {
                        l = index+1;
                        continue;
                    }
                }

                else if (nums[index] < target) {
                    l = index+1;
                }

                else r = index-1;

            }
            return output;
        }
    };