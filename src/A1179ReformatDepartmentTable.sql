SELECT id,
SUM(CASE `month` WHEN 'Jan' THEN revenue ELSE NULL END) as 'Jan_Revenue',
SUM(CASE `month` WHEN 'Feb' THEN revenue ELSE NULL END) as 'Feb_Revenue',
SUM(CASE `month` WHEN 'Mar' THEN revenue ELSE NULL END) as 'Mar_Revenue',
SUM(CASE `month` WHEN 'Apr' THEN revenue ELSE NULL END) as 'Apr_Revenue',
SUM(CASE `month` WHEN 'May' THEN revenue ELSE NULL END) as 'May_Revenue',
SUM(CASE `month` WHEN 'Jun' THEN revenue ELSE NULL END) as 'Jun_Revenue',
SUM(CASE `month` WHEN 'Jul' THEN revenue ELSE NULL END) as 'Jul_Revenue',
SUM(CASE `month` WHEN 'Aug' THEN revenue ELSE NULL END) as 'Aug_Revenue',
SUM(CASE `month` WHEN 'Sep' THEN revenue ELSE NULL END) as 'Sep_Revenue',
SUM(CASE `month` WHEN 'Oct' THEN revenue ELSE NULL END) as 'Oct_Revenue',
SUM(CASE `month` WHEN 'Nov' THEN revenue ELSE NULL END) as 'Nov_Revenue',
SUM(CASE `month` WHEN 'Dec' THEN revenue ELSE NULL END) as 'Dec_Revenue'
FROM Department
GROUP BY id


+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| revenue       | int     |
| month         | varchar |
+---------------+---------+
(id, month) is the primary key of this table.
The table has information about the revenue of each department per month.
The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].