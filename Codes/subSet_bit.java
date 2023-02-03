public class SubSetBinaryCountingTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(input);
}

	private static void generateSubSet(int[] input) {
		int N = input.length;
		
		for(int flag=0, caseCount = 1<<N ; flag < caseCount; flag++) {
			// flag : 원소들의 선택상태의 비트맵
			for(int i=0; i<N; i++) {	// 각 비트열의 상태를 확인
				if((flag & 1<<i) !=0 ) {
					System.out.print(input[i]+ " ");
				}
			}
			
			System.out.println();
		}
	}
	
}
