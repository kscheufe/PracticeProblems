/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing
order, and two integers m and n, representing the number of elements in 
nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead 
be stored inside the array nums1. To accommodate this, nums1 has a length 
of m + n, where the first m elements denote the elements that should be 
merged, and the last n elements are set to 0 and should be ignored. nums2 
has a length of n.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //for length of nums1
        int x = m+n;
        for (int i = 0; i < x; i++) {
            //check if nums1's original elements have all been sorted
            if (m==0)
            {
                //if they have, populate the rest of nums2 in
                for (int j = n; j>0;j--) 
                {
                    nums1[n-1] = nums2[n-1];
                    n--;
                }
                continue;
            }
            //if nums2 is empty, nums1's elements will already be sorted correctly
            if (n==0)
            {
                continue;
            }
            //check if nums1 next highest element is greater than nums2 next highest element
            if (nums1[m-1] > nums2[n-1])
            {
                //greater one goes into nums1[m+n]
                nums1[m+n-1] = nums1[m-1];
                //reset value of num1s old highest number to 0
                nums1[m-1] = 0;
                //greater value's index gets decremented
                m--;
            }
            else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            } 
        }
        
    }
}