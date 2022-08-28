public class DijkstraTest_sc_list {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<int[]>[] g = new List[V];
		int start = 0;
		
		for(int i=0; i<V; i++) g[i] = new ArrayList<int[]>();

		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[from].add(new int[] {to, cost});
		}
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용
		for(int i=0; i<V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[V]; 	// 최소비용 확정 여부
		
		distance[start] = 0;		// 시작점 0으로
		
		for(int i=0; i<V; i++) {
			int min = Integer.MAX_VALUE, current=0;
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			for(int[] j : g[current]) {
				if(!visited[j[0]] && distance[j[0]] > distance[current] + j[1]) {
					distance[j[0]] = distance[current] + j[1];
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[V-1]);
		sc.close();
		
	}

}
