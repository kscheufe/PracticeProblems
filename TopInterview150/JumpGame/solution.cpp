class Solution {
public:
    bool canJump(vector<int>& nums) {
        //set distance to 1 to enter the array
        int distance = 1;
        //iterate through the array, except for the last element
        for (int i = 0; i < nums.size()-1; i++)
        {
            //decrement distance each step taken
            distance--;
            //if the current pos gives you further reach, take it
            if (nums[i] > distance)
            {
                distance = nums[i];
            }
            //if you're out of steps return false
            else if (distance == 0)
            {
                return false;
            }
        }
        //otherwise if you reach the end return true
        return true;
    }
};