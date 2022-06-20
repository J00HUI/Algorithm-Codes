## Sliding window
![image](https://user-images.githubusercontent.com/83942393/174523304-253e762e-ca8a-4654-88d1-39009b9f5656.png)

예를 들어 ABCDEF 가 있고 K가 3이라면,

S1 = A+B+C, S2 = B+C+D,  ....

이런식으로 구하지 않고, B와 C는 중복되므로 S2를 구할 때 앞에서 구한 S1에서 A를 뺴고 새로운 D를 넣어 구하는 방식이다. 마치 창문처럼 이동하면서 구간 합을 구할 수 있는 간단한 알고리즘이다. 
</br></br>

### 활용 문제
[백준] https://www.acmicpc.net/problem/15961
</br></br>

### 코드
```
import java.io.*;
import java.util.*;
 
public class Main_bj_15961_회전초밥 {
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_15961.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());    // 접시의 갯수
        int D = Integer.parseInt(st.nextToken());    // 초밥의 종류
        int K = Integer.parseInt(st.nextToken());    // 연속해서 먹어야 하는 접시 수
        int C = Integer.parseInt(st.nextToken());    // 쿠폰
        
        int[] dishes = new int[N];
        for(int i=0; i<N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }
        
        int[] count = new int[D+1];    // D 종류의 초밥 갯수를 셀 배열
        count[C]++;    // 쿠폰 추가
        int cnt=1;        // 초밥의 종류
        for(int i=0; i<K; i++) {
            if(count[dishes[i]]++ == 0) cnt++;
        }
        
        int max = cnt;
        for(int i=1; i<N; i++) {
            // i-1 번째 빼기
            if(--count[dishes[i-1]] == 0) cnt--;
            // i+K 번째 넣기 
            if(count[dishes[(i+K-1)%N]]++ == 0) cnt++;
            max = Math.max(max, cnt);
        }
        
        System.out.println(max);
        br.close();
    }
 
}
```
