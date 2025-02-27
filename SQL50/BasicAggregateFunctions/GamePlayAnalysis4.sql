/*
Table: Activity

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key (combination of columns with 
unique values) of this table.
This table shows the activity of players of some games.
Each row is a record of a player who logged in and played a number of 
games (possibly 0) before logging out on someday using some device.
 

Write a solution to report the fraction of players that logged in again 
on the day after the day they first logged in, rounded to 2 decimal places. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.

The result format is in the following example.

 

Example 1:

Input: 
Activity table:
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-03-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
Output: 
+-----------+
| fraction  |
+-----------+
| 0.33      |
+-----------+
Explanation: 
Only the player with id 1 logged back in after the first day he had 
logged in so the answer is 1/3 = 0.33
*/

#second solution, much faster
select Round(count(distinct player_id) / (
    select count(distinct player_id) From Activity
), 2) as fraction
From activity
where (player_id, Date_sub(event_date, interval 1 day))# where a row exists that has a same id as in the original table, and a login date one day later
IN (
    select player_id, min(event_date) as first_login
    from activity
    group by player_id
)


#first solution, pretty slow
with t as (
    Select 
        player_id, 
        event_date, 
        row_number() over (Partition by player_id order by event_date asc) as rn
    FROM Activity
) 
select Coalesce(ROUND(count(*)/total, 2), 0) as fraction
from t t1
join t t2
    on t1.player_id = t2.player_id
    and t1.rn = 1
    and t2.rn = 2
    and t2.event_date = Date_ADD(t1.event_date, interval 1 day)
join (
    select Count(distinct(player_id)) as total
    from activity
) as t3