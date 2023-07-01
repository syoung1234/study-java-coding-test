# Study Algorithm Coding Test with Java

자료구조 <br>
정렬 <br>
탐색 <br>
그리디 <br>
정수론 <br>

## Chapter 3. 자료구조
#### 배열과 리스트
1. [숫자의 합 구하기](src/Chapter3/problem1.java)
2. [평균 구하기](src/Chapter3/problem2.java)
#### 구간 합
3. [구간 합 구하기 1](src/Chapter3/problem3.java)
4. [구간 합 구하기 2](src/Chapter3/problem4.java)
5. [나머지 합 구하기](src/Chapter3/problem5.java)
6. [연속된 자연수의 합 구하기](src/Chapter3/problem6.java)
#### 투 포인터
7. [주몽의 명령](src/Chapter3/problem7.java)
8. ['좋은 수' 구하기](src/Chapter3/problem8.java)
#### 슬라이딩 윈도우
9. [DNA 비밀번호](src/Chapter3/problem9.java)
10. [최솟값 찾기 1](src/Chapter3/problem10.java)
#### 스택과 큐
11. [스택으로 오름차순 수열 만들기](src/Chapter3/problem11.java)
12. [오큰수 구하기](src/Chapter3/problem12.java)
13. [카드 게임](src/Chapter3/problem13.java)
14. [절대값 힙 구현하기](src/Chapter3/problem14.java)

## Chapter 4. 정렬
#### 버블 정렬
- 시간 복잡도: O(n^2)
15. [수 정렬하기](src/Chapter4/problem15.java)
16. [버블 소트 프로그램 1](src/Chapter4/problem16.java)
#### 선택 정렬
- 시간 복잡도: O(n^2)
17. [내림차순으로 자릿수 정렬하기](src/Chapter4/problem17.java)
#### 삽입 정렬
- 시간 복잡도: O(n^2)
18. [ATM 인출 시간 계산하기](src/Chapter4/problem18.java)
#### 퀵 정렬
- 시간 복잡도: O(nlogn) ~ o(n^2)
19. [K번째 수 구하기](src/Chapter4/problem19.java)
#### 병합 정렬
- 시간 복잡도: O(nlogn)
20. [수 정렬하기 2](src/Chapter4/problem20.java)
21. [버블 소트 프로그램 2](src/Chapter4/problem21.java)
#### 기수 정렬
- 시간 복잡도: O(Kn)
22. [수 정렬하기 3](src/Chapter4/problem22.java)

## Chapter 5. 탐색
#### 깊이 우선 탐색
- 시간 복잡도: O(V+E)
23. [연결 요소의 개수 구하기](src/Chapter5/problem23.java)
24. [신기한 소수 찾기](src/Chapter5/problem24.java)
25. [친구 관계 파악하기](src/Chapter5/problem25.java)
#### 너비 우선 탐색
- 시간 복잡도: O(V+E)
26. [DFS와 BFS 프로그램](src/Chapter5/problem26.java)
27. [미로 탐색하기](src/Chapter5/problem27.java)
28. [트리의 지름 구하기](src/Chapter5/problem28.java)
#### 이진 탐색
- 시간 복잡도: O(logN)
29. [원하는 정수 찾기](src/Chapter5/problem29.java)
30. [블루레이 만들기](src/Chapter5/problem30.java)
31. [배열에서 K번째 수 찾기](src/Chapter5/problem31.java)

## Chapter 6. 그리디
#### 그리디 알고리즘
32. [동전 개수의 최솟값 구하기](src/Chapter6/problem32.java)
33. [카드 정렬하기](src/Chapter6/problem33.java) - 우선순위 큐
34. [수를 묶어서 최댓값 만들기](src/Chapter6/problem34.java)
35. [회의실 배정하기](src/Chapter6/problem35.java)
36. [최솟값을 만드는 괄호 배치 찾기](src/Chapter6/problem36.java)

## Chapter 7. 정수론
#### 소수 구하기
37. [소수 구하기](src/Chapter7/problem37.java) - Math.sqrt
38. [거의 소수 구하기](src/Chapter7/problem38.java)
39. [소수 & 팰린드롬 수 중에서 최솟값 찾기](src/Chapter7/problem39.java) - 에라토스테네스의 체
40. [제곱이 아닌 수 찾기](src/Chapter7/problem40.java) - 에라토스테네스의 체 이용
#### 오일러의 피
41. [오일러 피 함수 구현하기](src/Chapter7/problem41.java)
#### 유클리드 호제법
42. [최소 공배수 구하기](src/Chapter7/problem42.java) - 최소 공배수 = a*b/최대 공약수
43. [최대 공약수 구하기](src/Chapter7/problem43.java)
44. [칵테일 만들기](src/Chapter7/problem44.java)
#### 확장 유클리드 호제법
45. [Ax + By = C](src/Chapter7/problem45.java)

## Chapter 11. 동적계획법 (Dynamic Programming)
- [피보나치 수열 TopDown](src/Chapter11/피보나치_TopDown.java)
- [피보나치 수열 BottomUp](src/Chapter11/피보나치_BottomUp.java)
84. [정수를 1로 만들기](src/Chapter11/problem84.java) - 조건 모두 확인하기
85. [퇴사 준비하기](src/Chapter11/problem85.java) - 뒤에서부터 계산
86. [이친수 구하기](src/Chapter11/problem86.java) - 2진수 0,1
87. [2*N 타일 채우기](src/Chapter11/problem87.java) - dp[i-1] + dp[i-2]
88. [계단 수 구하기](src/Chapter11/problem88.java) - 2차원 배열
89. [연속된 정수의 합 구하기](src/Chapter11/problem89.java) - 왼쪽 방향, 오른쪽 방향