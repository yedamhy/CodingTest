# CodingTest
코딩테스트 뿌수기

## 시험 직전 암기 사항
### 배열 관련
- 배열 복사
    `System.arraycopy( 복사 대상 배열,  시작 지점, 복사해서 저장할 배열, 복사 대상의 시작 지점, 길이)`
- 배열에서 최댓값, 최솟값 찾기
  - `Arrays.stream(arr).max().getAsInt();`
  - `Arrays.stream(arr).min().getAsInt();`
 
- 요소로 인덱스 위치 찾기
  어레이List.indexOf(찾고 싶은 값);
  - ArrayList인 arr에서 b의 위치를 찾아보자 → `int location = arr.indexOf("b");`
  - 배열인 arr에서 b의 위치를 찾아보자 → `int location = Arrays.asList(arr).indexOf("b");`

- 특정 값 존재하는 지 확인하기
  - ArrayList에서 `if(strList.contains("BCD"))`

- 배열 정렬
  
  - 오름차순 : `Collections.sort(arr);`
  - 내림차순 : `Collections.sort(arr, Collections.reverseOrder());`

  - `Collections.sort()` 메서드가 `List` 타입의 객체를 정렬하는 메서드

  - int[] 같이 배열은 `Arrays.sort(arr);`

- 배열 문자열 길이를 기준으로 정렬
  - `Arrays.sort(phone_book, (a, b) -> Integer.compare(a.length(), b.length()));`

### 숫자 관련 
- float을 반올림 해서 int 형으로 반환
    - `int intValue = (int) Math.round(doubleValue);`

