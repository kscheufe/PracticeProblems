class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        count = 0
        n = len(citations)
        hIndices = [0] * (n+1)
        for i in range(len(citations)):
            if (citations[i] > n):
                hIndices[n]+=1
            else:
                hIndices[citations[i]]+=1
        """start(inclusive), stop(exclusive), step"""
        for i in range(len(citations), -1, -1):
            count+=hIndices[i]
            if count >= i:
                return i
        return -1
        
