## Hanoi (Recursive)
</br>

> 원판이 n개 일 때 옮긴 횟수 : 2^n-1

n 이 20 보다 크다면 long 범위를 벗어남 -> BigInteger 사용 
```Java
BigInteger ans = new BigInteger("2");
System.out.println(ans.pow(N).subtract(new BigInteger("1")));
```
</br>

### 전체 코드
```Java
public class R2_HanoiTest {

	public static void main(String[] args) {
		hanoi(3, 1, 2, 3);

	}
	public static void hanoi(int n, int from, int temp, int to) {
		if(n==0) {
			return;
		}
		// n-1개(덩어리) 원판  temp 로 이동
		hanoi(n-1, from, to, temp);
		
		// n 번 원판 이동
		System.out.println(n+" : "+from+"->"+to);
		
		// n-1개(덩어리) 원판 이동
		hanoi(n-1, temp, from, to);
	}

}
```
