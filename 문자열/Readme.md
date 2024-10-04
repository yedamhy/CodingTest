# Char ↔︎ String

### 1. char → String 변환
- 방법 1: `Character.toString()` 사용
```java
char ch = 'a';
String str = Character.toString(ch);
System.out.println(str);  // 출력: "a"
```
- 방법 2: `String.valueOf()` 사용
``` java
char ch = 'b';
String str = String.valueOf(ch);
System.out.println(str);  // 출력: "b"
```

- 방법 3: 문자열 덧셈 (+) 사용
```java
char ch = 'c';
String str = ch + "";
System.out.println(str);  // 출력: "c"
```

### 2. String → char 변환
- 방법 1: charAt() 사용
```java
String str = "hello";
char ch = str.charAt(0);  // 첫 번째 문자 'h' 추출
System.out.println(ch);  // 출력: 'h'
```
- 방법 2: toCharArray() 사용
```java
String str = "world";
char[] charArray = str.toCharArray();  // 문자열을 char 배열로 변환
System.out.println(charArray[0]);  // 출력: 'w'
```

# 대문자 ↔︎ 소문자

### 1. Char 변환
- 대문자로 : `Character.toUpperCase()` 사용
```java
char lowercase = 'a';
char uppercase = Character.toUpperCase(lowercase);
System.out.println(uppercase);  // 출력: 'A'
```

- 소문자로 : `Character.toLowerCase()` 사용
```java
char uppercase = 'A';
char lowercase = Character.toLowerCase(uppercase);
System.out.println(lowercase);  // 출력: 'a'
```
### 2. 문자열 전체 변환
- 대문자로 : `String.toUpperCase()` 메서드를 사용
```java
String lowercaseStr = "hello world";
String uppercaseStr = lowercaseStr.toUpperCase();
System.out.println(uppercaseStr);  // 출력: "HELLO WORLD"
```

- 소문자로 : `String.toLowerCase()` 메서드를 사용
```java
String uppercaseStr = "HELLO WORLD";
String lowercaseStr = uppercaseStr.toLowerCase();
System.out.println(lowercaseStr);  // 출력: "hello world"
```
