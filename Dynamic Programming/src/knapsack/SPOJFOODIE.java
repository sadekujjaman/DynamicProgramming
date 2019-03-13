package knapsack;

import java.util.*;
import java.io.*;
import java.lang.*;

public class SPOJFOODIE {

	static long max = 10000000000000000L;
	static int[] units = new int[101];
	static int cap = 0;
	static int n = 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
			n = sc.nextInt();
			cap = sc.nextInt();
			Arrays.fill(units, 0);
			
			for(int i = 1; i <= n; i++){
				int r = sc.nextInt();
				for(int j = 0; j < r; j++){
				        units[i]+=sc.nextInt();
				}
			}
			
			int ans = solve(1,0);
			System.out.println(ans);
			
		}
		
		sc.close();

	}
	private static int solve(int i, int k) {
		
		if (i == n + 1)
			return 0;
		int profit1 = 0;
		int profit2 = 0;
		if(units[i] + k <= cap)
			profit1 = units[i] + solve(i + 1, k + units[i]);
		else
			profit1 = 0;
		profit2 = solve(i + 1, k);
		
		return Math.max(profit1, profit2);
	}

	
}