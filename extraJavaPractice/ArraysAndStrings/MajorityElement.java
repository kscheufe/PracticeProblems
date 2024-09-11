class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int majValue = nums[0];
        //linear time, O(1) space solution (MAJORITY ELEMENT WILL OCCUPY MORE THAN HALF THE SPACES)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majValue)
            {
                counter++;
            }
            else counter--;
            if (counter == 0)
            {
                majValue = nums[i+1];
            }
        }
        return majValue;

        //initial solution
        /*
        if (nums.length < 3) return nums[0];
        for (int i = 0; i <= nums.length/2; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[j] == nums[i])
                {
                    counter++;
                }
            }
            if (counter >= nums.length/2) return nums[i];
            counter = 0;
        }
        return -111111;
         */
    }
}