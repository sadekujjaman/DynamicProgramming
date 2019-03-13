package basic;

import java.util.Scanner;

public class SPOJEDIST {

	static char[] chars1;
	static char[] chars2;
	
	static int[][] dp = new int[2005][2005];
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int test  = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
			String str1 = sc.next();
			String str2 = sc.next();
			chars1 = str1.toCharArray();
			chars2 = str2.toCharArray();
			
			int cols = str1.length();
			int rows = str2.length();
			
			for(int i = 0; i <= cols; i++){
				dp[0][i] = i;
			}
			for(int i = 0; i <= rows; i++){
				dp[i][0] = i;
			}
			
			for(int i = 1; i <= rows; i++){
				for(int j = 1; j <= cols; j++){
					if(chars2[i - 1] == chars1[j - 1]){
						dp[i][j] = dp[i - 1][j - 1];
					}
					else{
						dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
					}
				}
			}
			System.out.println(dp[rows][cols]);
			
		}
		
		
		sc.close();
	}

}
