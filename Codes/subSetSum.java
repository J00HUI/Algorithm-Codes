
public class SubSetSumTest {
	static int N, input[], S, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 집합의 크기
		S = sc.nextInt(); 	 // 목표합
		ans = 0;
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0);
		System.out.println(ans);
	}
	
	public static void generateSubSet(int cnt) { // 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		if(cnt==N) { // 마지막 원소까지 부분집합에 고려된 상황
			int sum = 0;
			int elementCnt = 0;
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sum += input[i];
					elementCnt++;
				}
			}
			
			if(sum == S && elementCnt>0) {
				++ans;
				for(int i=0; i<N; i++) {
					System.out.print(isSelected[i] ? input[i]+" " : "");
				}
				System.out.println();
			}
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
	}

}

//-7 -3 -2 5 8
