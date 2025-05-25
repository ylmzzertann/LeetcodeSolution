# Write your MySQL query statement below
SELECT teacher_id, COUNT(*) AS cnt
FROM (
    SELECT DISTINCT teacher_id, subject_id
    FROM Teacher
) AS unique_subjects
GROUP BY teacher_id;