package lis;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {

	final static int MAX = 1000;
	static int dp[] = new int[MAX];
	static int dir[] = new int[MAX];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Arrays.fill(dp, -1);
		Arrays.fill(dir, -1);

		int n = sc.nextInt();
		int arr[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		int lis = 0;
		int start = 1;

		for (int i = 1; i <= n; i++) {
			int lisTemp = longest(i, arr);
			if (lisTemp >= lis) {
				start = i;
				lis = lisTemp;
			}
		}
		System.out.println("LIS: " + lis + " from Starting point " + start);
		System.out.print("Direction: ");
		while(start != -1){
			System.out.print(arr[start] + " ");
			start = dir[start];
		}
		System.out.println();
		sc.close();

	}

	private static int longest(int u, int[] arr) {

		if (dp[u] != -1)
			return dp[u];
		
		int max = 0;
		for(int v = u + 1; v < arr.length; v++){
			if(arr[u] < arr[v]){
				int lis = longest(v, arr);
				if(lis > max){
					max = lis;
					dir[u] = v;
				}
			}
		}
      return dp[u] = 1 + max;

	}

}
