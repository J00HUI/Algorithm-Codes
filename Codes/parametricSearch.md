 ## Parametric Search
 * 이진 탐색과 비슷
 * 위키피디아에 따르면 Nimrod Megiddo라는 사람이 발명한 최적화 문제를 결정 문제로 풀 수 있는 기술.
 * 최적화 문제는 어떤 알고리즘의 최적의 솔루션을 찾아내는 것. 즉, 가능한 여러개의 답 중 가장 좋은 답을 찾는 것
 * 결정 문제는 답이 이미 결정되어있다고 보고 문제를 푸는 것.
 * 풀이 방식은 이진 탐색과 비슷하다. start, end, mid 값을 이용해 mid 값이 답이 된다면 start를 mid+1 로 놓고 (또는 end 를 mid-1) 다시 mid 값을 계산해 최적의 답을 찾아가는 문제 해결 방식
 * ex) 부서에 출근한 사원의 수를 모를 때, 몇 개의 아이스크림을 사가야 최적의 갯수일까? 단, 사갈 아이스크림의 갯수를 결정하면 모두가 아이스크림을 먹을 수 있는지 없는지는 알 수 있다.
 * <b>5개 아이스크림 결정 -> 모두가 먹을 수 없다. -> 범위 조정, 7개로 조정 -> 모두가 먹을 수 있다. -> 범위 조정, 6개로 조정 -> 반복</b>
 * 이진 탐색과 다른 점은 이진 탐색은 원하는 값을 찾는 다면 반복문을 멈추지만, 매개변수 탐색은 최적의 답을 찾기 위해 반복한다.
* 시간복잡도는 이진탐색과 마찬가지로 O(logN)

[참고 블로그](https://www.acmicpc.net/problem/2343)
</br>
</br>

### 활용 문제
[BOJ 2343 기타레슨](https://www.acmicpc.net/problem/2343)
```
import java.io.*;
import java.util.*;

public class Main_bj_2343_기타레슨 {
	
	// parametric search 
	static boolean isOK(int value, int N , int M, int[] arr) {
		int sum = 0;					// 1개에 담기는 영상의 총 길이
		int m = 1;					// 사용한 블루레이의 갯수
		for(int i=0; i<N; i++) {
			if(arr[i] > value) return false;	// 현재 길이에 영상을 넣을 수 없음
			sum += arr[i];
			if(sum > value) {			// 블루레이 길이 초과
				sum = arr[i];			// 새거에 현재 영상 담음
				m++;				// 블루에이 갯수 증가
			}
		}
		
		if(m>M) return false;				// 사용한 블루레이 갯수가 더 많다면 길이를 증가시켜야 함
		return true;						
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2343.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());		// N 개의 영상들
		int M = Integer.parseInt(st.nextToken());		// M 개의 블루레이에 연속으로 담아야 함
		int[] arr = new int[N];					// 영상들
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int last = 100000000;
		
		while(start<=last) {
			int mid = (start+last)/2;					// 블루레이 영상의 길이
			
			boolean result = isOK(mid, N, M, arr);
			
			if(result) {							// 현재 블루레이 길이에 M개를 사용해 영상을 전부 담을 수 있다면
				last = mid-1;						// 제일 적은 길이를 찾기 위해 -1
			}else {								// 없다면
				start = mid+1;						// 길이 증가
			}
		}
		
		
		System.out.println(start);
		br.close();

	}

}


```
