public class DP1_LISTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];		// 수열의 원소들 저장
		int[] LIS = new int[N]; 	// 자신을 끝으로 하는 LIS 길이
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;	// 해당 수열의 LIS 최장 길이
		for(int i=0; i<N; i++) {	// 모든 원소에 대해서 자신을 끝으로 하는 LIS 길이 계산
			LIS[i] = 1; 	// 자신 혼자 LIS 구성할 때의 길이 1로 초기화
			
			for(int j=0; j<i; j++) {	// 첫 원소부터 i 원소 직전까지 비교
				if(arr[i] > arr[j] && LIS[i] < LIS[j]+1) {		// arr[j] < arr[i] : 증가수열의 모습
					LIS[i] = LIS[j]+1;
				}
			}
			
			if(max < LIS[i]) max = LIS[i];
		}
		
		System.out.println(max);
		sc.close();
	}

}

=============================================================================================================================
/**
 * @author taeheekim
 */
public class LISTest2_BinarySearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int[] C = new int[N];
		
		for (int i = 0; i < N; i++) arr[i] = s.nextInt();
		
		int size = 0;
        for (int i=0; i < N; i++) {

            int temp = Arrays.binarySearch(C, 0, size, arr[i]); // 리턴값 : -insertPoint -1
            temp = Math.abs(temp)-1;//삽입위치
            C[temp] = arr[i];// temp 자리에 값을 update 하면 그 의미는 
            			     // 0인덱스 위치부터 temp위치까지의 원소 갯수가  temp위치에 저장된 그 값을 마지막으로 하는 LIS 길이가 됨
            				 // 배열의 원소가 LIS를 이루는 구성요소와는 관계가 없다.

            if (size == temp) {// 삽입위치의 인덱스와 크기가 같으면(결국,마지막이 삽입위치라는 얘기임) 크기 1늘림.
                size++;
            }
        }
        System.out.println(size);
	}

}
