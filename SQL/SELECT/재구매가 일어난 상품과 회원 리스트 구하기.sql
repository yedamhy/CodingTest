-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
SELECT DISTINCT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
WHERE (USER_ID, PRODUCT_ID) IN (
    SELECT USER_ID, PRODUCT_ID
    FROM ONLINE_SALE
    GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(*) > 1
)
ORDER BY USER_ID, PRODUCT_ID DESC;
