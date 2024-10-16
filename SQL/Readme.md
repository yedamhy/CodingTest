# 문자열
### 특정 단어로 시작하는 것 찾기
- `LIKE` 사용!
    ```sql
    SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
    FROM FOOD_FACTORY
    WHERE ADDRESS LIKE '강원도%';
    ```

### 숫자에 문자열 붙여서 반환하기
- `CONCAT` 사용!
    ```sql
    SELECT CONCAT(SUM(D_BETWEEN_DIST), 'km') AS TOTAL_DISTANCE
    ```
## 날짜 관련
### 1) 날짜→ 문자열

DATE FORMAT(날짜, 출력 형식)을 사용한다

```sql
SELECT DATE_FORMAT('2019-09-16 20:23:12', '%Y/%M/%D')
--  2019/09/16 출력
```
```sql
SELECT DATE_FORMAT(컬럼 이름, '%Y-%m-%d')
--- 2021-06-10 출력
```
### 2) 문자열 → 날짜 

STR_TO_DATE(문자, 출력 형식) 
```sql
SELECT STR_TO_DATE('20080101', '%Y-%M-%D')  
--  20080101이라는 문자를 2008-01-01의 형태의 날짜로 리턴
```

# WHERE절에서 IN 사용하기
```SQL
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
```

# 조건에 따라 값 주기
- `CASE` 이용
  
  예시 : 평가 점수에 따라 등급 선정하고 col 이름 GRADE
  ```sql
    SELECT E.EMP_NO, EMP_NAME, 
        CASE
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE  'C'
        END AS GRADE

  ```

# 중복 방지
`DISTINCT`
