# 문자열
## 특정 단어로 시작하는 것 찾기
```sql
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%';
```

- `LIKE` 사용!
