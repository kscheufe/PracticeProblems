class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        totalGasMinusCost = 0
        currentGasMinusCost = 0
        index = 0
        active = False
        for x in range(len(gas)):
            totalGasMinusCost += gas[x] - cost[x]
            currentGasMinusCost += gas[x] - cost[x]
            if (currentGasMinusCost > 0 and not active):
                index = x
                active = True
            if (currentGasMinusCost < 0):
                index = -1
                active = False
                currentGasMinusCost = 0
        if totalGasMinusCost < 0:
            return -1
        return index
        