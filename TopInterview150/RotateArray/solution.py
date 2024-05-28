class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        'mod k because it is not guaranteed to be less than the length of nums'
        k = k%len(nums)
        "reverse array"
        nums.reverse()
        nums1 = []
        nums2 = []
        "split arrays"
        for x in range(len(nums)):
            print(x)
            if x < k:
                nums1.append(nums[x])
            else:
                nums2.append(nums[x])
        "reverse sub arrays"
        nums1.reverse()
        nums2.reverse()
        'join arrays back together'
        for x in range(len(nums)):
            if (x < k):
                nums[x] = nums1[x]
            else:
                nums[x] = nums2[x-k]