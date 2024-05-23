/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        //likewise to the previous algorithm, start with the guaranteed number of correct elements (in this case 2)
        int counter = 2;
        //for the remaining elements in the array
        for (int i = 2; i < nums.length; i++)
        {
            //if the current element is different than either of the two elements preceding the value at index counter (the next open index)
            if (nums[i] != nums[counter-1] || nums[i] !=nums[counter-2])
            {
                //place it in the next open index
                nums[counter] = nums[i];
                //incrment the counter (also moves the index forward)
                counter++;
            }
        }
        //return the counter
        return counter;
    }
}