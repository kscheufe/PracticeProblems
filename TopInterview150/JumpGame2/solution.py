class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        "loop through reachable positions, keeping track of the furthest position reachable"
        "when loop finished, rerun the loop with the new data points reachable"
        "only increment the jumps per full iteration through the loop to ensure we don't skip any positions"
        "will find the fewest jumps to reach the finish from index 0"
        target = len(nums) - 1
        i=0 
        maxReachable=0
        lastPosition=0
        jumps = 0
        while (lastPosition < target):
            if nums[i]+i > maxReachable:
                maxReachable = nums[i]+i
            if i == lastPosition:
                lastPosition = maxReachable
                jumps+=1
            i+=1
        return jumps