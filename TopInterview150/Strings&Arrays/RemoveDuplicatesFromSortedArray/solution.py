class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        "set couter to 1 because the first element is definitely unique"
        counter = 1
        "for the rest of the elements"
        for x in range(1, len(nums), 1):
            "check if they are equal to the previous element (nums is sorted)"
            if (nums[x-1] != nums[x]):
                "if not equal, add the current value to the position of counter (next index of a unique number)"
                nums[counter] = nums[x]
                "increment the counter"
                counter+=1
        "return the counter"
        return counter