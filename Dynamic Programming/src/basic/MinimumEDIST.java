package basic;

public class MinimumEDIST {

	static char[] chars1;
	static char[] chars2;
	
	static int[][] dp = new int[20][20];
	
	
	public static void main(String[] args) {
	
		String str1 = "look at";
		String str2 = "google";
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

}
