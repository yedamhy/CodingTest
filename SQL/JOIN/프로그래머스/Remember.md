# Remeber!
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
