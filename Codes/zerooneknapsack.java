public class DP2_KnapSackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		int[][] results = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt(); 
		}
		
		int itemWeight = 0 , itemBenefit=0;
		
		for(int item=1; item<=N; item++) {
			itemWeight = weights[item];		// 현 아이템의 무게
			itemBenefit = profits[item];		// 현 아이템의 가치
		
		
			// 현 아이템의 1부터 목표 무게 까지의 가치테이블을 만든다.
			for(int weight = 1; weight <= W; weight++) {
				if(itemWeight <= weight) {
					results[item][weight] = Math.max(results[item-1][weight], itemBenefit+results[item-1][weight-itemWeight]);
				} else {
					results[item][weight] = results[item-1][weight];
				}
			}
		}
		System.out.println(results[N][W]);
		sc.close();
	}

}

===============================================================================================================================
public class Solution_d3_3282_01Knapsack {

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] weight = new int[N+1];
			int[] value = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[K+1];	// K까지 무게를 담아야 함
			for(int i=1; i<=N; i++) {	// N개의 물건을 고려해야 함
				for(int w=K; w>0; w--) {
					if(w<weight[i]) continue;	// 현재 고려 무게에 현재 물건을 담을 수 없다면
					else {
						dp[w] = Math.max(dp[w], dp[w-weight[i]] + value[i]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[K]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}

  
