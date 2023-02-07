import java.io.*;
import java.util.*;


/*
 * 무방향 그래프를 오름차순으로 DFS로 탐색하기.
 * 정점을 방문한 순서 출력하기.
 */

public class Main_bj_24479_깊이우선탐색1 {
	
	static int[] ans;
	static int idx;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_24479.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		ans = new int[N+1];
		idx = 1;
	
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(adjList[i]);
		}
		
		// DFS
		DFS(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void DFS(int now) {
		ans[now] = idx++;
		
		for(int neighbor : adjList[now]) {
			if(ans[neighbor] == 0) {	// 아직 방문하지 않은 정점
				DFS(neighbor);
			}
		}
	}

}
