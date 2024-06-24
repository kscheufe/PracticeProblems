class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        //std::vector<int> returnArr[nums.size];
        vector<int> returnArr(nums.size(), 0);//declares size of nums.size filled with 0s
        returnArr[0] = 1;
        for (int i = 1; i < nums.size(); i++)
        {
            returnArr[i] = returnArr[i-1] * nums[i-1];
        }
        int revProduct = 1;
        for (int i = nums.size()-1; i >=0; i--)
        {
            returnArr[i] *= revProduct;
            revProduct = revProduct*nums[i];
        }
        return returnArr;
    }
};