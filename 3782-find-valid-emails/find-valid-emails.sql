# Write your MySQL query statement below
SELECT user_id, email
FROM Users
WHERE 
    email LIKE '%@%.com' -- sadece temel geçerli formatı alanlar
    AND LENGTH(email) - LENGTH(REPLACE(email, '@', '')) = 1 -- yalnızca 1 tane @ olmalı
    AND SUBSTRING_INDEX(email, '@', 1) REGEXP '^[a-zA-Z0-9_]+$' -- @ öncesi sadece alfanümerik ve _
    AND SUBSTRING_INDEX(SUBSTRING_INDEX(email, '.', 1), '@', -1) REGEXP '^[a-zA-Z]+$' -- @ sonrası .com'dan önceki domain sadece harf
ORDER BY user_id;