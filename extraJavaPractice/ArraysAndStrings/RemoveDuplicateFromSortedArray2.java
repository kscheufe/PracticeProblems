class Solution {
    public int removeDuplicates(int[] nums) {
        //same as last, each can appear at most twice
        //lol do it with a hashmap
        int totalUnique = 2;
        if (nums.length == 1) return 1;
        for (int i = 2; i < nums.length; i++)
        {
            if (!(nums[i] == nums[totalUnique-1] && nums[i]==nums[totalUnique-2]))
            {
                nums[totalUnique] = nums[i];
                totalUnique++;
            }
        }
        return totalUnique;
    }
}