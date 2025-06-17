# Write your MySQL query statement below
SELECT person_name
FROM (
  SELECT
    person_name,
    turn,
    SUM(weight) OVER (ORDER BY turn) AS running_total
  FROM Queue
) AS t
WHERE running_total <= 1000
ORDER BY turn DESC
LIMIT 1;
