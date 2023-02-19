public class DP0_FibonacciTest_Recur {

	private static long[] callCnt1, callCnt2, memo;
	private static long totalCnt1, totalCnt2;
	
	// 재귀 사용
	public static long fibo1(int n) {
		callCnt1[n]++;
		totalCnt1++;
		if(n<2) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	// dp 사용
	public static long fibo2(int n) {
		callCnt2[n]++;
		totalCnt2++;
		//if(n>=2 && memo[n]==0) {	// 메모 여부 확인
		if(memo[n] == -1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		callCnt1 = new long[n+1];
		callCnt2 = new long[n+1];
		memo = new long[n+1];	// 0으로 자동 초기화
		Arrays.fill(memo, -1);	// -1으로 초기화
//		memo[0] = 0;
//		memo[1] = 1;
		memo[1] = 1;
		memo[2] = 1;	// -1로 초기화 안해도 됨
		
		System.out.println(fibo2(n));
		for(int i=0; i<=n; i++) {
			System.out.println("fibo2(" + i + ") : " + callCnt2[i]);
		}
		System.out.println("totalCnt2 : " + totalCnt2);
		System.out.println("=======================================");
		
		System.out.println(fibo1(n));
		for(int i=0; i<=n; i++) {
			System.out.println("fibo1(" + i + ") : " + callCnt1[i]);
		}
		System.out.println("totalCnt1 : " + totalCnt1);
	}

}


// 10
// 55
// fibo2(0) : 0
// fibo2(1) : 1
// fibo2(2) : 2
// fibo2(3) : 2
// fibo2(4) : 2
// fibo2(5) : 2
// fibo2(6) : 2
// fibo2(7) : 2
// fibo2(8) : 2
// fibo2(9) : 1
// fibo2(10) : 1
// totalCnt2 : 17
// =======================================
// 55
// fibo1(0) : 34
// fibo1(1) : 55
// fibo1(2) : 34
// fibo1(3) : 21
// fibo1(4) : 13
// fibo1(5) : 8
// fibo1(6) : 5
// fibo1(7) : 3
// fibo1(8) : 2
// fibo1(9) : 1
// fibo1(10) : 1
// totalCnt1 : 177

