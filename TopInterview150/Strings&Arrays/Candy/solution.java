/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104

*/

//create an answer array
//everyone gets one candy
//add a candy for a child who has a higher rating than his neighbor, and add to a candy counter
//if the child after a +1 has a higher rating, give him an extra candy and increase the counter
//if he's lower, only give him one and reset the counter
//after this is done go through the list backwards and ensure it works in reverse, checking the relative ratings match the candies and updating where it doesn't
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;//set the first value to 1
        int total = 0;//set the total to 0 for now
        int counter = 1;//set the counter to 1 (first value to add)
        //forward ranking
        System.out.print("1, ");
        for (int i = 1; i < ratings.length; i++)
        {
            candies[i] = 1;
            if (ratings[i] > ratings[i-1])//if current rating is higher than previous
            {
                candies[i] = candies[i-1]+1;
                /*    above does the same thing but better
                candies[i] += counter;
                counter++;
                */
            }
            else 
            {
                candies[i] = 1;
                //counter = 1;
            }
            System.out.print(candies[i] + ", ");
        }
        System.out.print("\n" + candies[ratings.length-1] + ", ");
        //backward ranking
        total += candies[ratings.length-1];
        for (int i = ratings.length-2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
            {
                candies[i] = candies[i+1] + 1;
            }
            total += candies[i];
            System.out.print(candies[i] + ", ");
        }
        return total;
        
    }
}

//works but is very slow despite being O(n) time

//one pass method from solutions
//faster, and it works, but their description is a little shotty
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
        {return 0;}

        int returnn = 1;
        int up = 0;
        int down = 0;
        int peak = 0;
        for (int i = 1; i < ratings.length; i++)
        {
            if (ratings[i] > ratings[i-1])
            {
                up += 1;
                down = 0;
                peak = up;
                returnn += up + 1;
            }
            else if (ratings[i] == ratings[i-1])
            {
                up = down = peak = 0;
                returnn += 1;
            }
            else{
                up = 0;
                down++;
                returnn += down;
                if (peak < down)
                {
                    returnn += 1;
                }
            }
        }
        return returnn;
    }
}