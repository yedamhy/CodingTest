-- https://school.programmers.co.kr/learn/courses/30/lessons/144856
SELECT A.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE)  AS TOTAL_SALES
FROM BOOK_SALES S
JOIN BOOK B
ON S.BOOK_ID = B.BOOK_ID
    JOIN AUTHOR A
    ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE SALES_DATE LIKE '2022-01%'
GROUP BY A.AUTHOR_ID, CATEGORY
ORDER BY A.AUTHOR_ID, CATEGORY DESC;
