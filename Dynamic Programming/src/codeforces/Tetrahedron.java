package codeforces;

import java.util.*;

public class Tetrahedron {

	private static final int N = 10000001;
	private static final int MOD = 1000000007;
	
	private static int dp[][][] = new int[4][4][N];
	private static boolean vis[][][] = new boolean[4][4][N];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(count(3, 3, n));
		
		sc.close();
		
	}

	private static int count(int src, int dest, int steps) {
		
		if(steps == 0)
		{
			if(src == dest)
				return 1;
			else
				return 0;
		}
		
		if(vis[src][dest][steps])
			return dp[src][dest][steps];
	
		vis[src][dest][steps] = true;
		int ans = 0;//dp[src][dest][steps];
		for(int i = 0; i < 4; i++){
			if(i == src)
				continue;
			ans += count(i, dest, steps - 1);
			
			ans = ans % MOD;
			
		}
		dp[src][dest][steps] = ans;
			
		//System.out.println(ans);
		
		return dp[src][dest][steps];
	}
	
	
}
