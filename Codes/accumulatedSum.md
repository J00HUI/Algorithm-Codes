## 누적 합 (구간 합)
> 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
</br>

* ex) 1, 2, 3, 4, 5 를 입력 받으면 배열(sum)에 {1, 3, 6, 10, 15 } 를 저장
* 2 ~ 5 구간 합을 구하고 싶다면, 5 번째 누적합인 15에서 1까지의 누적합 1을 뺸다. 답은 14
* 2 ~ 4 구간 합을 구하고 싶다면, 4 번째 누적합인 10에서 1까지의 누적합 1을 뺀다. 답은 9
* 즉, sum[end] - sum[start-1]
</br>

```Java
int[] sum = new int[N+1];		// 누적 합
for(int i=1; i<=N; i++) {
  sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
}

for(int i=0; i<M; i++) {
  int start = Integer.parseInt(st.nextToken());
  int end = Integer.parseInt(st.nextToken());
  sb.append(sum[end] - sum[start-1]).append("\n");
}
```
