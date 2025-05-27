# Write your MySQL query statement below
SELECT
    ds.date_id,
    ds.make_name,
    ul.unique_leads,
    up.unique_partners
FROM
    (SELECT date_id, make_name, COUNT(*) AS unique_leads
     FROM (SELECT DISTINCT date_id, make_name, lead_id FROM DailySales) AS leads
     GROUP BY date_id, make_name) AS ul
JOIN
    (SELECT date_id, make_name, COUNT(*) AS unique_partners
     FROM (SELECT DISTINCT date_id, make_name, partner_id FROM DailySales) AS partners
     GROUP BY date_id, make_name) AS up
ON ul.date_id = up.date_id AND ul.make_name = up.make_name
JOIN
    (SELECT DISTINCT date_id, make_name FROM DailySales) AS ds
ON ds.date_id = ul.date_id AND ds.make_name = ul.make_name;
