/*
Given an integer array nums and an integer val, remove all occurrences of 
val in nums in-place. The order of the elements may be changed. Then return
the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to
get accepted, you need to do the following things:

- Change the array nums such that the first k elements of nums contain the 
  elements which are not equal to val. The remaining elements of nums are 
  not important as well as the size of nums.
- Return k.
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        //create a counter for the number of non "val" elements found
        int counter = 0;
        //iterate through the array
        for (int i = 0; i < nums.length; i++)
        {
            //if the current index is non-"value"
            if (nums[i] != val)
            {   
                //then move it to the position of how many 
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}

