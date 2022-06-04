public class DijkstraTest_sc {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int[][] g = new int[V][V];
		int start = 0;
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				g[i][j] = sc.nextInt();
			}
			distance[i] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[V]; 	// 최소비용 확정 여부
		
		distance[start] = 0;		// 시작점 0으로
		
		for(int i=0; i<V; i++) {
			// 단계 1 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE, current=0;
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			// 단계 2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for(int j=0; j<V; j++) {
				if(!visited[j] && g[current][j] != 0 && distance[j] > distance[current] + g[current][j]) {
																distance[j] = distance[current] + g[current][j];
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[V-1]);
		sc.close();
		
	}

}
