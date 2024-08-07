class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        output = []
        intervals.sort(key = lambda x: x[0])
        print(intervals)
        
        index = 0
        for i in range(len(intervals)):
            """ if the first index or no overlap"""
            if index == 0 or output[index-1][1] < intervals[i][0]:
                output.append(intervals[i])
                index+=1
            else:
                output[index-1][1] = max(output[index-1][1], intervals[i][1])

        
        return output