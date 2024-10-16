# 어떤 조인을 써야할까?
**예시 데이터**
#### 테이블 1: Customers (고객 정보)
|Customer_ID|	Name|	City|
|:---: | :---: | :---: | 
|1|	Alice|	Seoul|
|2	|Bob|	Busan|
|3|	Carol|	Incheon|


#### 테이블 2: Orders (주문 정보)
|Order_ID|Customer_ID|	Product|
|:---: | :---: | :---: | 
|1	|1|	Laptop|
|2	|2	|Smartphone|
|3	|1	|Headphones|
|4|	4	|Keyboard|


## 1. NATURAL JOIN
- 자동으로 같은 이름을 가진 컬럼을 기준으로 조인

  ```sql
  SELECT * 
  FROM Customers NATURAL JOIN Orders;
  ```
  **결과**
  | Customer_ID | Name  | City  | Order_ID | Product     |
  |-------------|-------|-------|----------|-------------|
  | 1           | Alice | Seoul | 1        | Laptop      |
  | 1           | Alice | Seoul | 3        | Headphones  |
  | 2           | Bob   | Busan | 2        | Smartphone  |

## 2. LEFT JOIN
- 왼쪽 테이블에 있는 모든 행을 반환하고, 오른쪽 테이블에 일치하는 데이터가 없으면 NULL로 표시
- Ex) 모든 고객의 목록을 보고 싶지만, 주문을 하지 않은 고객(Carol)도 표시하고 싶을 때
  ```sql
  SELECT Customers.Customer_ID, Name, City, Product
  FROM Customers 
  LEFT JOIN Orders 
  ON Customers.Customer_ID = Orders.Customer_ID;
  ```
  **결과**
  | Customer_ID | Name  | City    | Product     |
  |-------------|-------|---------|-------------|
  | 1           | Alice | Seoul   | Laptop      |
  | 1           | Alice | Seoul   | Headphones  |
  | 2           | Bob   | Busan   | Smartphone  |
  | 3           | Carol | Incheon | NULL        |

- 언제 사용?
  - 왼쪽 테이블에 있는 모든 데이터가 반드시 필요할 때

## 3. RIGHT JOIN
- 오른쪽 테이블의 모든 행을 반환하고, 왼쪽 테이블에 일치하는 데이터가 없으면 NULL로 표시
- Ex) 주문 목록을 보고 싶지만, 주문자가 없는 경우도 포함하고 싶을 때
  ```sql
  SELECT Customers.Customer_ID, Name, City, Product
  FROM Customers 
  RIGHT JOIN Orders 
  ON Customers.Customer_ID = Orders.Customer_ID;

  ```
  **결과**
  | Customer_ID | Name  | City  | Product     |
  |-------------|-------|-------|-------------|
  | 1           | Alice | Seoul | Laptop      |
  | 1           | Alice | Seoul | Headphones  |
  | 2           | Bob   | Busan | Smartphone  |
  | 4           | NULL  | NULL  | Keyboard    |

- 언제 사용?
  - 오른쪽 테이블의 모든 데이터가 반드시 필요할 때
    
## FULL OUTER JOIN
- 양쪽 테이블의 모든 데이터를 반환
- 일치하지 않는 부분은 null로 표시

  *주의!* MySQL은 `FULL OUTER JOIN`을 지원하지 않으므로  `UNION`을 이용해서 구현
  ```sql
  SELECT Customers.Customer_ID, Name, City, Product
  FROM Customers 
  LEFT JOIN Orders 
  ON Customers.Customer_ID = Orders.Customer_ID
  UNION
  SELECT Customers.Customer_ID, Name, City, Product
  FROM Customers 
  RIGHT JOIN Orders 
  ON Customers.Customer_ID = Orders.Customer_ID;
  
  ```
  **결과**
  
  | Customer_ID | Name  | City    | Product     |
  |-------------|-------|---------|-------------|
  | 1           | Alice | Seoul   | Laptop      |
  | 1           | Alice | Seoul   | Headphones  |
  | 2           | Bob   | Busan   | Smartphone  |
  | 3           | Carol | Incheon | NULL        |
  | 4           | NULL  | NULL    | Keyboard    |
