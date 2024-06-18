class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        returnArr = [1]*len(nums)
        for x in range(1, len(nums), 1):
            returnArr[x] = returnArr[x-1]*nums[x-1]
        reverseProduct = 1
        """x from len(nums)-1, last element, until it hits -1, after 0th element"""
        for x in range(len(nums)-1, -1, -1): 
            returnArr[x] *= reverseProduct
            reverseProduct *= nums[x]
        return returnArr


"""
calculate a forward product for each element (all the elements before it)
calculate a backward product for each element (all the elements after it)
"""