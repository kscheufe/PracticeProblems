class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        "set beginning distance to 0"
        distanceAvailable = 0
        "iterate through the array"
        for x in range(len(nums)):
            "if currentPosition has a farther reach than previous, jump here and gain that distance"
            if nums[x] > distanceAvailable:
                distanceAvailable = nums[x]
            "if you've reached the end return true "
            if x == len(nums)-1:
                return True
            "if you're at max distance and not finished return false"
            if distanceAvailable == 0:
                return False
            "decrement your distance available for the next iteration"
            distanceAvailable-=1
        