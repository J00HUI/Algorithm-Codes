import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge {
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
	
	static int INF = 100_000_000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11657.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> edgeList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(a, b, c));
		}
		
		// 벨만 포드
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		// 정점의 갯수 만큼 반복
		for(int i=1; i<=N; i++) {
			
			for(Edge edge : edgeList) {
				if(dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.cost) {
					dist[edge.v] = dist[edge.u] + edge.cost;
				}
			}
		}
		
		boolean res = false;
		// 음의 사이클 확인
		for(int i=1; i<=N; i++) {
			
			for(Edge edge : edgeList) {
				if(dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.cost) {
					res = true; 
					break;
				}
			}
		}
		
		if(res) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<=N; i++) {
				if(dist[i] >= INF) {
					sb.append(-1).append("\n");
				}
				else sb.append(dist[i]).append("\n");
			}
			
			System.out.println(sb.toString());
		}
		
		br.close();
		
	}

}
