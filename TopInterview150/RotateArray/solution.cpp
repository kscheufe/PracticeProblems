class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        //reverse array
        std::reverse(std::begin(nums), std::end(nums));
        //split array
        std::vector<int> nums1(k);
        std::vector<int> nums2(nums.size()-k);

        for (int i = 0; i < nums.size(); i++)
        {
            if (i<k)
            {
                nums1[i] = nums[i];
            }
            else 
            {
                nums2[i-k] = nums[i];
            }
        }
        //reverse sub arrays
        std::reverse(std::begin(nums1), std::end(nums1));
        std::reverse(std::begin(nums2), std::end(nums2));
        //join arrays back together in nums
        for (int i = 0; i < nums.size(); i++)
        {
           if (i<k)
            {
                nums[i] = nums1[i];
            }
            else 
            {
                nums[i] = nums2[i-k];
            } 
        }
    }
};