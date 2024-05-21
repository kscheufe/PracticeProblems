"""
You are given two integer arrays nums1 and nums2, sorted in non-decreasing
order, and two integers m and n, representing the number of elements in 
nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead 
be stored inside the array nums1. To accommodate this, nums1 has a length 
of m + n, where the first m elements denote the elements that should be 
merged, and the last n elements are set to 0 and should be ignored. nums2 
has a length of n.
"""
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        #set length of while loop
        i = m + n
        while i > 0:
            #if second array is empty leave the while loop
            if n==0:
                i=0
            #if first array is finished, populate all the elements of the second
            elif m==0: 
                for x in range(n,0,-1):
                    nums1[x-1] = nums2[x-1]
                i=0
            elif nums1[m-1] > nums2[n-1]:
                nums1[m+n-1] = nums1[m-1]
                m-=1
            else:
                nums1[m+n-1] = nums2[n-1]
                n-=1
            i-=1
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        