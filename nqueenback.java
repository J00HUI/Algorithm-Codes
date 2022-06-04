public class NQueenBackTrackingTest {

	static int N, ans;
	static int col[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N+1];
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야하는 현재 행
		if(!isAvailable(rowNo-1)) return;  // 직전까지의 상황이 유망하지 않다면 리턴
		
		// 기저조건 : 퀸을 모두 놓았다면
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) {	// rowNo : 놓아진 마지막 퀸의 행
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false;
		}
		
		return true;
	}

}


================================================================================================================================
public class NQueenBackTrackingTest2 {

	static int N, ans;
	static int col[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N+1];
		
//		if(isAvailable(0)) {  // 원래 이렇게 해줘야 하나 0 퀸은 무조건 유망하기 때문에 뺴줘도 됨
//			setQueen(1);
//		}
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야하는 현재 행
		
		// 기저조건 : 퀸을 모두 놓았다면
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			
			if(isAvailable(rowNo)) {
				setQueen(rowNo+1);
			}
		}
	}
	
	public static boolean isAvailable(int rowNo) {	// rowNo : 놓아진 마지막 퀸의 행
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false;
		}
		
		return true;
	}

}
