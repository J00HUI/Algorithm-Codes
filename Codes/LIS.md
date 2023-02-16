## LIS
> 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열 구하기   
> ex) 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {**10**, **20**, 10, **30**, 20, **50**} 이고, 길이는 4이다.   
</br>

* int[] input : 입력으로 들어오는 수열 , List<Integer> Lis : 증가하는 부분 수열   
입력으로 숫자가 들어올 때 2가지 경우로 나뉜다.   
1. Lis 의 맨 뒤의 숫자보다 클 때
2. Lis 의 맨 뒤의 숫자보다 작거나 같을 때

* Lis 의 맨 뒤 숫자보다 현재 입력으로 들어온 숫자가 더 크다면 맨 뒤에 넣어준다.   
* 작거나 같다면, 현재 숫자보다 큰 숫자의 위치를 찾아 바꾼다. (이분 탐색으로 들어갈 위치를 찾는다.)   
    * 대소관계는 유지되는데 더 작은 수로 교체되는 것이므로 다음에 들어올 수가 더 많아진다.
    * ex) Lis : { 10, 20, 30 }
    * 들어온 수 : 21
    * Lis : {10, 20, 21 }
    * 들어온 수 : 12
    * Lis : {10, 12, 21 }
* Lis 의 크기를 출력한다. 
</br>

```Java
import java.io.*;
import java.util.*;

public class Main_bj_12015_증가하는부분수열2_sol2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_12015.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> Lis = new ArrayList<>();
		Lis.add(0);
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(Lis.get(Lis.size()-1) < num) {
				Lis.add(num);
			} else {
				// num 이 들어갈 자리 찾기 (num 과 대소관계가 같은 곳과 교체 (대소관계는 유지되는데 더 작은 수로 교체되는 것이므로 다음에 들어올 수가 더 많아짐))
				// 이분탐색
				int start = 0;
				int end = Lis.size()-1;
				int ans = 0;
				while(start <= end) {
					int mid = (start+end)/2;
					
					if(Lis.get(mid) < num) {
						start = mid+1;
					} else {
						ans = mid;
						end = mid-1;
					}
				}
				
				Lis.set(ans, num);
			}
		}
		
		System.out.println(Lis.size()-1);	// 처음에 넣어준 0 빼기
		br.close();
	}

}

```
