import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_1753_최단경로 {
	static class Node {
		int vertex, weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1753.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, w, adjList[from]);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));		// 최소 우선 순위 큐
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(distance[now[0]] < now[1]) continue;
			
			for(Node temp = adjList[now[0]]; temp != null; temp = temp.link) {
				if(distance[temp.vertex] > distance[now[0]] + temp.weight) {	// 현재 최소 비용이 가장 적은 정점을 거쳐가는 것이 더 비용이 적다면
					distance[temp.vertex] = distance[now[0]] + temp.weight;
					pq.offer(new int[] {temp.vertex, distance[temp.vertex]});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(distance[i] >= Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(distance[i]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}

// BOJ 1753 정답 Code
