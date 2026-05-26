WITH FirstPositive AS (
    -- Step 1: Find the first positive test date for each patient
    SELECT 
        patient_id, 
        MIN(test_date) AS first_pos_date
    FROM covid_tests
    WHERE result = 'Positive'
    GROUP BY patient_id
),
FirstNegativeAfter AS (
    -- Step 2: Find the first negative test date that happens AFTER the first positive
    SELECT 
        fp.patient_id,
        fp.first_pos_date,
        MIN(ct.test_date) AS first_neg_date
    FROM FirstPositive fp
    JOIN covid_tests ct 
      ON fp.patient_id = ct.patient_id 
     AND ct.result = 'Negative' 
     AND ct.test_date > fp.first_pos_date
    GROUP BY fp.patient_id, fp.first_pos_date
)
-- Step 3: Include the 'age' column and sort as required
SELECT 
    fna.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(fna.first_neg_date, fna.first_pos_date) AS recovery_time
FROM FirstNegativeAfter fna
JOIN patients p ON fna.patient_id = p.patient_id
ORDER BY recovery_time ASC, p.patient_name ASC;