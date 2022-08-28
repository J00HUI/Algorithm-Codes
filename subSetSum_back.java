public class SubSetSumTest2 {
	static int N, input[], S, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	 // 집합의 크기
		S = sc.nextInt(); 	 // 목표합
		ans = 0;
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0, 0);
		System.out.println(ans);
	}
	
	public static void generateSubSet(int cnt, int sum) { // cnt : 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
													                              // sum : 직전까지 구성된 부분집합의 합
		if(sum == S) {
			++ans;
			for(int i=0; i<cnt; i++) {
				System.out.print(isSelected[i] ? input[i]+" " : "");
			}
			System.out.println();
			
			return;
		}
		if(sum > S) return;		// 가지치기
		
		if(cnt==N) { 			// 마지막 원소까지 부분집합에 고려된 상황 (기저조건)
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubSet(cnt+1, sum+input[cnt]);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubSet(cnt+1, sum);
	}

}

//5 21 11 16 6 10
