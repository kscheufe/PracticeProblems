class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueCounter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1])
            {
                nums[uniqueCounter] = nums[i];
                uniqueCounter++;
            }
        }


        return uniqueCounter;
    }
}