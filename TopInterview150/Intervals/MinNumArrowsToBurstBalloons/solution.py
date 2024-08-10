class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort(key = lambda x: x[1])
        counter = 1
        shotPointer = points[0][1]

        for point in points:
            if point[0] > shotPointer:
                counter+=1
                shotPointer = point[1]

        return counter