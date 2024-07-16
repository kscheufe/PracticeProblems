/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I


Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000




P   A   H   N
A P L S I I G
Y   I   R
--------
analysis:
first pass: 1, 5, 9, 13
second pass: 2, 4, 6, 8, 10, 12, 14
third pass: 3, 7, 11
--------

P     I    N
A   L S  I G
Y A   H R
P     I
--------
analysis:
first pass: 1, 7, 13
second pass: 2, 6, 8, 12, 14
third pass: 3, 5, 9, 11
fourth pass: 4, 10
--------

p       H
A     S I
Y   I   R
P L     I G
A       N
--------
analysis
first pass: 1, 9
second pass: 2, 8, 10
third pass: 3, 7, 11
fourth pass: 4, 6, 12, 14
fifth pass: 5, 13
--------

always takes numRows passes
mod quantity is numRows + numRows-2 (inside and outside edge)
for 1, mod 0
for 2, mod 2
for 3, mod 4
for 4, mod 6
for 5, mod 8

Then, inside rows analysis...

Wait a minute, I can just create numRows strings, populate them as I iterate through the array once, and return their concatenation!


*/

 //something mod numRows
 class Solution {
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        int rowIndex = 0;
        int dir = 1;

        //check edge cases
        if (numRows == 1 || numRows > s.length()) return s;

        //initialize rows array
        for (int i = 0; i < numRows; i++)
        {
            rows[i] = "";
        }

        //iterate through, sort chars
        for (int i = 0; i < s.length(); i++)
        {
            rows[rowIndex] = rows[rowIndex] + s.charAt(i);
            rowIndex += dir;
            if (rowIndex % (numRows-1) == 0)
            {
                dir *= -1;//switch direction when rowIndex hits a border
            }
        }

        //join strings
        for (int i = 1; i < numRows; i++)
        {
            rows[0] = rows[0] + rows[i];
        }
        return rows[0];
    }
}