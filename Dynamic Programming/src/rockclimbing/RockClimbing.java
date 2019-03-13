package rockclimbing;

import java.util.Arrays;
import java.util.Scanner;

public class RockClimbing {

	static int dp[][] = new int[10][10];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < dp.length; i++){
			Arrays.fill(dp[i], -1);
		}
		int row = sc.nextInt(); 
		int col = sc.nextInt(); 
		
		int[][] grid = new int[row][col];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
		         grid[i][j] = sc.nextInt();		
			}
		}
		System.out.println(call(0, 0, grid, row, col));
		sc.close();
	}


	static int call(int i, int j, int grid[][], int row, int col){
		
		
		if(i >= 0 && i < row && j >= 0 && j < col){
			if(dp[i][j] != -1)
				return dp[i][j];
			
			int result = -999999999;
			result = Math.max(result, call(i + 1, j, grid, row, col) + grid[i][j]);
			result = Math.max(result, call(i + 1, j - 1, grid, row, col) + grid[i][j]);
			result = Math.max(result, call(i + 1, j + 1, grid, row, col) + grid[i][j]);
			dp[i][j] = result;
			return result;
		}
		else
			return 0;
	}
}
