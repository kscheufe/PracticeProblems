class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == val) 
            {
                counter++;
            }
            else
                nums[i-counter] = nums[i];
        }       
        return nums.length - counter;
    }
}