class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        l = 0
        r = len(nums)-1
        output = [-1,-1]
        if len(nums) == 0:
            return output
        
        while l <= r:
            index = l + (r-l)/2

            if nums[index] == target:
                if index == 0 or nums[index-1] != target:
                    output[0] = index
                    break
                else:
                    r = index-1
            
            elif nums[index] < target:
                l = index+1
            else:
                r = index-1

        if output[0] == -1:
            return output
        l = output[0]
        r = len(nums) -1

        while l <= r:
            index = l + (r-l)/2

            if nums[index] == target:
                if index == len(nums)-1 or nums[index+1] != target:
                    output[1] = index
                    break
                else:
                    l = index+1
            
            elif nums[index] < target:
                l = index+1
            else:
                r = index-1
                
        return output