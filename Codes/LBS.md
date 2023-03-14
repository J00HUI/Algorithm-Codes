## 가장 긴 바이토닉 부분 수열
> 수열 A가 주어졌을 때, 가장 긴 바이토닉 부분 수열 구하기 </br>
> 바이토닉 수열 : 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이다. </br>

> ex) 수열 A = {1, 5, 2, 1, 4, 3, 4, 5, 2, 1} 인 경우에 가장 긴 바이토닉 부분 수열은 A = {**1**, 5, **2**, 1, 4, **3**, **4**, **5**, **2**, **1**} 이고, 길이는 7이다.
</br>

* DP 를 사용해 증가하는 부분 수열 찾기 (dp1)
* 마찬가지로 DP 를 사용해 감소하는 부분 수열 찾기 (dp2)
* dp1[i] + dp2[i] 의 값이 최댓값인 지점의 값 출력
</br>
</br>

```Java
import java.io.*;
import java.util.*;

public class Main_bj_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11054.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<i; j++) {
				if(numbers[j] < numbers[i] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[j] + 1;
				}
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if(numbers[j] < numbers[i] && dp2[i] < dp2[j]+1) {
					dp2[i] = dp2[j] + 1;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i]);
		}
		
		System.out.println(ans-1);
		br.close();
		
	}

}

```
