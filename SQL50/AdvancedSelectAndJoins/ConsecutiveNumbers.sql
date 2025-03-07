/*
Table: Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
In SQL, id is the primary key for this table.
id is an autoincrement column starting from 1.
 

Find all numbers that appear at least three times consecutively.

Return the result table in any order.

The result format is in the following example.

 

Example 1:

Input: 
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
Output: 
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
Explanation: 1 is the only number that appears consecutively for at 
least three times.
*/
# triple join solution
select distinct a.num as ConsecutiveNums
from logs a, logs b, logs c
where a.id = b.id-1 and b.id = c.id-1 and a.num = b.num and b.num = c.num

# Lag, Lead solution
select distinct(num) as ConsecutiveNums
from (
    select 
        id, 
        num,
        lag(num) over (order by id) as prev_num,
        lead(num) over (order by id) as next_num
    from logs
) as t1
where t1.num = prev_num and prev_num = next_num
/*
INNER QUERY RETURNS:
| id | num | prev_num | next_num |
| -- | --- | -------- | -------- |
| 1  | 1   | null     | 1        |
| 2  | 1   | 1        | 1        |
| 3  | 1   | 1        | 2        |
| 4  | 2   | 1        | 1        |
| 5  | 1   | 2        | 2        |
| 6  | 2   | 1        | 2        |
| 7  | 2   | 2        | null     |
*/