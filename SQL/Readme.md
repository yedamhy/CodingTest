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

# 순위 관련
### ROW_NUMBER()
각 행에 고유한 번호(순번)을 부여하는 함수 => 순위 계산, 중복 제거, 페이지네이션 등에 사용
- 사용 방법
  ```sql
    SELECT 
        ROW_NUMBER() OVER (PARTITION BY 컬럼1 ORDER BY 컬럼2) AS 순번,
        컬럼1, 컬럼2
    FROM 테이블;

  ```

- 예시
  테이블: Employees
    |EMP_NO	| DEPARTMENT |	NAME |	SALARY |
  |:---:|:---:|:---:|:---:|
   | 1	|HR|	Alice	|5000|
    |2|	HR	|Bob	|4500|
    |3	|IT	|Carol	|6000|
    |4	|IT	|Dave	|5500|
    |5	|IT	|Eve	|5000|

  - 부서별로 연봉 순위
    ```sql
    SELECT DEPARTMENT, NAME, SALARY,
            ROW_NUMBER() OVER (PARTITION BY DEPARTMENT ORDER BY SALARY DESC) AS RANK
    FROM EMPLOYEES;
    ```
  
