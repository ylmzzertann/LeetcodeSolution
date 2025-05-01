# Write your MySQL query statement below
WITH DuplicateIds AS (
    SELECT id
    FROM Person
    WHERE id NOT IN (
        SELECT MIN(id)
        FROM Person
        GROUP BY email
    )
)
DELETE FROM Person
WHERE id IN (SELECT id FROM DuplicateIds);
