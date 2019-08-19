package coinchange;

import java.util.Arrays;

public class CoinChange {
	static int make = 10;
	// static int[] coins = { 5, 8, 11, 15, 18 };
	static int[] coins = { 2, 3, 1, 5, 4 };
	static int numberOfCoins = coins.length;

	static int dp[][] = new int[6][100];

	public static void main(String[] args) {

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		// System.out.println(call(0, 0));
		int ans = call1(0, make);
		System.out.println(ans);
		callBottom(make);
	}

	static void callBottom(int money) {
		int n = coins.length;
		int m[][] = new int[n + 1][money + 1];
		for (int i = 0; i < n; ++i){
			for (int j = 1; j <= money; ++j) {
				int way1 = 0;
				int way2 = 0;
				if(i == 0){
					m[i][j] = 0;
					continue;
				}
				if (j >= coins[i]) {

					if ((m[i][money - coins[i]] == 1) || (money == coins[i]))
						way1 = 1;
				}
				way2 = m[i - 1][j];
				m[i][j] = way1 + way2;
			}
		}
		
		
		System.out.println(m[n][money]);
	}

	static int call1(int i, int amount) {
		if (i >= numberOfCoins) { // All coins have been taken
			if (amount == 0)
				return 1;
			else
				return 0;
		}
		if (dp[i][amount] != -1)
			return dp[i][amount]; // no need to calculate same state twice
		int ret1 = 0, ret2 = 0;
		if (amount - coins[i] >= 0)
			ret1 = call1(i, amount - coins[i]); // try to take coin i
		ret2 = call1(i + 1, amount); // dont take coin i
		return dp[i][amount] = ret1 + ret2; // storing and returning.

	}

	static int call(int i, int amount) {

		if (i >= numberOfCoins) {
			if (amount == make)
				return 1;
			else
				return 0;
		}
		if (dp[i][amount] != -1) {
			return dp[i][amount];
		}
		int result1 = 0;
		int result2 = 0;
		if (coins[i] + amount <= make) {
			result1 = call(i, coins[i] + amount);
		}
		result2 = call(i + 1, amount);
		// int result = result1 | result2;
		return dp[i][amount] = result1 | result2;
		// return result;
	}
}
