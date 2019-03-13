package knapsack;

import java.util.*;


public class SPOJWACHOPHIA {

	static int weight[] = new int[60];
	static int cost[] = new int[60];
	
	static int cap = 0;
	static int bags = 0;
	static int dp[][] = new int[60][1010];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
//			Arrays.fill(weight, 0);
//			Arrays.fill(cost, 0);
			for(int i = 0; i <= 55; i++){
				Arrays.fill(dp[i], -1);
			}
			cap = sc.nextInt();
			bags = sc.nextInt();
			
			for(int i = 1; i <= bags; i++){
				weight[i] = sc.nextInt();
				cost[i] = sc.nextInt();
			}
			int ans = solve(1, cap);
			System.out.println("Hey stupid robber, you can get " + ans + ".");
			
		}
		
		sc.close();
	}
	private static int solve(int i, int w) {
		
		if(i > bags)
			return 0;
		
		if(dp[i][w] != -1)
			return dp[i][w];
		
		int profit1 = 0;
		int profit2 = 0;
		if(w >= weight[i]){
			profit1 = cost[i] + solve(i + 1, w - weight[i]);
		}
		else
			profit1 = 0;
		
		profit2 = solve(i + 1, w);
		
		return dp[i][w] = Math.max(profit1, profit2);
	}

}
