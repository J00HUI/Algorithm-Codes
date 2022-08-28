public class CombinationNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		int[] p = new int[N];
		// p 배열에 0보다 큰 값으로 R 개를 맨 뒤부터 채운다.
		// 4C2 0011
		int cnt = 0;
		while (++cnt <= R)
			p[N - cnt] = 1;

		do {
			
			for(int i=0; i<N; i++) {
				if(p[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();

		} while (np(p));

	}

	static boolean np(int[] p) {
		int N = p.length;
		
		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;

		// 2. 교환 위치에 교환할 값 찾기
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;

		// 3. 교환위치와 교환할 값 교환하기
		swap(p, i - 1, j);

		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = N - 1;
		while (i < k) { // 둘이 같다면 원소가 하나라는 뜻
			swap(p, i++, k--);
		}

		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
