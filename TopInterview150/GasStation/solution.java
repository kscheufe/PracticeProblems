/**
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

 

Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 

Constraints:

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104

Analysis:
Trivial solution is n^2 algorithm where you check every starting pos

if total cost > total gas, return -1
if a solution does exist, it will be unique
iterating through example 1, gas - cost would be [-2, -2, -2, +3, +3],
or if we chose to start at [0], would be [-2, -4, -6, -3, 0]. 
Correct answer in this case is [3] (fourth index), 
because it gets all the positve gas numbers first then loses gas.

If the position has negative gas you can't start there! Has to be 
first positive value after the last negative one? Work backwards 
until you find arr[-ve], return []+1?

Let's try that and see more test cases
*/
/*
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasMinusCost = 0;
        int index = gas.length-1;
        boolean found = false;
        for (int i = gas.length-1; i >= 0; i--)
        {
            totalGasMinusCost += gas[i]-cost[i];
            if (gas[i]-cost[i] < 0 && found == false)
            {
                found = true;
                index = (i+1) % gas.length;
            }
        }
        if (totalGasMinusCost < 0) {
            return -1;
        }
        else return index;
    }
}
*/
/*
Doesn't work as expected
New Test case 
gas = 7, 1, 0, 11, 4
cost = 5, 9, 1, 2, 5
gas - cost = 2, -8, -1, 9, -1

Maybe just the highest value is the starting pos, 
but that doesn't feel right either
try it for more info
*/
/*

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasMinusCost = 0;
        int index = gas.length-1;
        //boolean found = false;
        int highest = 0;
        for (int i = gas.length-1; i >= 0; i--)
        {
            totalGasMinusCost += gas[i]-cost[i];
            if (gas[i] - cost[i] >= highest)
            {
                index = i;
                highest = gas[i]-cost[i];
            }
        }
        if (totalGasMinusCost < 0) {
            return -1;
        }
        else return index;
    }
}*/

/*
does not work either
thinking more abstract, the array will be separated into sections 
of +ve and -ve gas-cost values. Subsequent -ve and +ve values could be
grouped together into one index
-1, -1, -1, +2, +2, -2, -1, +2
could become
-3, +4, -3, +2
Then we could also reduce to
-3, +1, +2
and 
-3, +3
before finally 
0
So, we're looking for the first index of +3 in
-3, +3
which is +1 in
-3, +1, +2
which is +4 in
-3, +4, -3, +2
which is the first +2 in the first line

Another test case is
g = [5, 8, 2, 8]
c = [6, 5, 6, 6]
t = [-1, 3, -4, 2]
correct answer is [3] (fourth index)

Hint is "if you start at a and get stuck at b, nothing between a and b
can be correct", so start at [0], go until you can't get any further,
then try again from [failure] +1, until you can make it to the end

Without doing this in n^2, we can keep track of the g-c value,
if it's negative we can't start there
if it's positive we can keep going until it gets negative or finishes,
If it finishes, return the index, if it's negative, start again and 
update the index

*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasMinusCost = 0;
        int currentGasMinusCost = 0;
        int index = 0;
        boolean found = false;
        for (int i = 0; i < gas.length; i++)
        {
            totalGasMinusCost += (gas[i]-cost[i]);
            currentGasMinusCost += (gas[i]-cost[i]);
            if (gas[i] - cost[i] >= 0)
            {
                if (!found)
                {
                    index = i;
                    found = true;
                }
            }
            else if (currentGasMinusCost < 0)
            {
                found = false;
                currentGasMinusCost = 0;
            }
        }
        if (totalGasMinusCost < 0) {
            System.out.println(totalGasMinusCost);
            return -1;
        }
        else return index;
    }
}

/*
works, let's examine
- we keep track of total gas-cost to see if it's solvable at all
if it isn't, we quick return -1
- otherwise, we also keep track of a current gas-cost value, which gets
reset to 0 if we ever find a town that makes this value negative, since 
that invalidates all starting positions before it.
- When the for loop finishes, it will have the index of the starting
position that was able to finish the array saved, which will be the last
and only valid solution.
- we don't have to worry about any costs to high to traverse, as it will 
be taken care of by the total gas-cost check
*/