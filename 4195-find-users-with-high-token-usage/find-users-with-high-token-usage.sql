WITH user_token_metrics AS (
    SELECT 
        user_id,
        tokens,
        COUNT(*) OVER(PARTITION BY user_id) AS prompt_count,
        AVG(tokens) OVER(PARTITION BY user_id) AS avg_tokens
    FROM prompts
)
SELECT 
    user_id,
    prompt_count,
    ROUND(avg_tokens, 2) AS avg_tokens
FROM user_token_metrics
WHERE prompt_count >= 3          -- Filter 1: At least 3 prompts
  AND tokens > avg_tokens        -- Filter 2: At least one prompt exceeds own average 
GROUP BY user_id, prompt_count, avg_tokens
ORDER BY avg_tokens DESC, user_id ASC;