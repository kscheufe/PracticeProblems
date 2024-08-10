class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        output = []
        index = 0
        n = len(intervals)

        while index < n and newInterval[0] > intervals[index][1]:
            output.append(intervals[index])
            index+=1

        while index < n and newInterval[1] >= intervals[index][0]:
            newInterval[0] = min(newInterval[0], intervals[index][0])
            newInterval[1] = max(newInterval[1], intervals[index][1])
            index+=1
        output.append(newInterval)

        while index < n:
            output.append(intervals[index])
            index += 1

        return output