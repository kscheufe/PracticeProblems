class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        p1 = 0
        p2 = len(height)-1
        maxVolume = 0
        while p1 < p2:
            currentMax = min(height[p1], height[p2]) * (p2-p1)
            maxVolume = max(currentMax, maxVolume)
            if height[p1] < height[p2]:
                p1+=1
            else:
                p2-=1

        return maxVolume