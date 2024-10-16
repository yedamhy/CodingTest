-- https://school.programmers.co.kr/learn/courses/30/lessons/284531
SELECT ROUTE, 
        CONCAT(round(SUM(D_BETWEEN_DIST), 1), 'km' ) AS TOTAL_DISTANCE, 
        concat(round(AVG(D_BETWEEN_DIST),2),'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY SUM(D_BETWEEN_DIST) DESC;
