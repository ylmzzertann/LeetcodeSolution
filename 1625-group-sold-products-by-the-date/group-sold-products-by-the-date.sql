# Write your MySQL query statement below
SELECT
    sell_date,
    COUNT(*) AS num_sold,
    GROUP_CONCAT(product ORDER BY product SEPARATOR ',') AS products
FROM (
    SELECT DISTINCT sell_date, product
    FROM Activities
) AS unique_sales
GROUP BY sell_date
ORDER BY sell_date;