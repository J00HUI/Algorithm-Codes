## 의사 코드

```
merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
        merge_sort(A, p, q);      # 전반부 정렬
        merge_sort(A, q + 1, r);  # 후반부 정렬
        merge(A, p, q, r);        # 병합
    }
}

# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
merge(A[], p, q, r) {
    i <- p; j <- q + 1; t <- 1;
    while (i ≤ q and j ≤ r) {
        if (A[i] ≤ A[j])
        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
    }
    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
        tmp[t++] <- A[i++];
    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
        tmp[t++] <- A[j++];
    i <- p; t <- 1;
    while (i ≤ r)  # 결과를 A[p..r]에 저장
        A[i++] <- tmp[t++]; 
}
```

## Java
```Java
import java.io.*;
import java.util.*;

/*
 * input
 * 
 * 5
 * 4 5 1 3 2
 */

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_24060.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, N-1);
		br.close();
	}
	
	static void mergeSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int i = p, j = q+1, t = 1;
		int[] tmp = new int[N+1];
		while(i <= q && j<= r) {
			if(arr[i] < arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		
		while(i <= q) {			// 왼쪽 배열 부분이 남은 경우
			tmp[t++] = arr[i++];
		}
		while(j <= r) {			// 오른쪽 배열 부분이 남은 경우
			tmp[t++] = arr[j++];
		}
		
		i = p; 
		t=1;
		while(i <= r) {			// 결과를 A[p..r] 에 저장
			arr[i++] = tmp[t++];
		}
	}
}
```
