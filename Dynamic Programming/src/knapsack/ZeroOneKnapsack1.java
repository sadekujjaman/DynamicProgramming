package knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroOneKnapsack1 {

	static int size = 1002;
	static int weight[] = new int[size];
	static int cost[] = new int[size];
	static int numberOfItems = 0;
	static int capacity = 0;
	static int dp[][] = new int[size][size];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			numberOfItems = sc.nextInt();
			for (int i = 0; i < numberOfItems; i++) {
				cost[i] = sc.nextInt();
				weight[i] = sc.nextInt();
			}

			int person = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= person; i++) {
				capacity = sc.nextInt();
				for(int j = 0; j < dp.length; j++){
					Arrays.fill(dp[j], -1);
				}
				sum += knapsack(0, 0);
			}
			System.out.println(sum);
			//System.out.println(dp[1][0]);
		}

		sc.close();
	}

	private static int knapsack(int i, int w) {

		if (i >= numberOfItems)
			return 0;
		if (dp[i][w] != -1)
			return dp[i][w];
		int profit1 = 0, profit2 = 0;
		if (w + weight[i] <= capacity)
			profit1 = cost[i] + knapsack(i + 1, w + weight[i]);
		profit2 = knapsack(i + 1, w);
		dp[i][w] = Math.max(profit1, profit2);
		return dp[i][w];
	}

}
