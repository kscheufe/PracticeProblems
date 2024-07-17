"""two pass solution"""
class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        returnArr = [1]*len(ratings)
        for x in range(1, len(ratings), 1):
            if (ratings[x] > ratings[x-1]):
                returnArr[x] = returnArr[x-1]+1

        total = returnArr[len(returnArr)-1]
        for x in range(len(ratings)-2, -1, -1):
            if (ratings[x] > ratings[x+1] and returnArr[x] <= returnArr[x+1]):
                returnArr[x] = returnArr[x+1] + 1
            total += returnArr[x]
            
        return total
