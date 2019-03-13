package basic;

import java.util.Arrays;

public class LISNew {

	static int MAX = 10000;
	static int n = 7;// 0;
	static int arr[] = { -100000, 5, 0, 9, 2, 7, 3, 4 };// new int[MAX];
	static int dir[] = new int[MAX];
	static int dp[] = new int[MAX];

	public static void main(String[] args) {

		Arrays.fill(dp, -1);
		Arrays.fill(dir, -1);
		int lis = 0;
		int start = 0;

		for (int i = 1; i <= n; i++) {
			int temp = longest(i);
			if (lis < temp) {
				lis = temp;
				start = i;
			}
		}
		System.out.println("Lis = " + lis + ", start = " + start);
		solution(start);
	}

	private static int longest(int u) {
		if (dp[u] != -1)
			return dp[u];
		int maxi = 0;
		for (int v = u + 1; v <= n; v++) {
			if (arr[v] > arr[u]) {
				int temp = longest(v);
				if (temp > maxi) {
					maxi = temp;
					dir[u] = v;

				}
			}
		}
		dp[u] = 1 + maxi;
		return dp[u];
	}
	
	private static void solution(int start){
		while(start != -1){
		System.out.println("Index " + start + ", value " + arr[start]);
		start = dir[start];
		}
	}

}
