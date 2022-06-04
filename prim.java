public class MST2_PrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		
		int[][] adjMatrix = new int[N][N];
		int[] minEdge= new int[N];	// 타정점에서 현재 신장트리로 간선비용 중 최소비용
		boolean[] visited = new boolean[N];		// 신장트리에 포함 유무
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			
			minEdge[i] = Integer.MAX_VALUE;		// 충분히 큰 값으로 최소값 초기화
		}
		
		int result = 0;		// MST 비용
		minEdge[0] = 0;
		
		for(int c=0; c < N; c++) {	// N개의 정점을 모두 연결
			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;
			
			// 선택된 정점과 이웃한 정점들 중, 신장트리에 포함되지 않은 정점들 중 간선비용을 따져보고 최솟값을 갱신
			for(int i=0; i<N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 &&minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}
		
		System.out.println(result);
		
	}

}
