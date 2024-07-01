class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        leftMaxes = [0]*len(height)
        rightMaxes = [0]*len(height)
        currentMax = 0
        for x in range(len(height)):
            leftMaxes[x] = currentMax
            if height[x] > currentMax:
                currentMax = height[x]
        
        currentMax = 0
        for x in range(len(height)-1, -1, -1):
            rightMaxes[x] = currentMax
            if height[x] > currentMax:
                currentMax = height[x]
        """reuse currentMax as a Total counter"""
        currentMax = 0
        for x in range(len(height)):
            if (height[x] < leftMaxes[x] and height[x] < rightMaxes[x]):
                currentMax += min(leftMaxes[x], rightMaxes[x]) - height[x]
        return currentMax