package subsetsum;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * Sadekujjaman Saju
 * 
 */

public class SubsetSUMUVA {

	// static int INF = Integer.MAX_VALUE;
	// static int N_INF = Integer.MIN_VALUE;
	//
	// static int dp[] = new int[1005];
	//
	// static int vis[] = new int[1005];
	//
	// static int dirX[] = {-1, 1, 0, 0};
	// static int dirY[] = {0, 0, -1, 1};
	//
	// static int divCount[] = new int[1000005];
	//
	
	static long dp[][] = new long[105][50005];

	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);

	/*	
	    3
		1 2 1 2 1
		2 3 4 1 2 5 10 50 3 50
		3 5 2 7 1 7 5 2 8 9 1 25 15 8 3 1 38 45 8 1
		
		NO
		YES
		YES
		*/
		int test = sc.nextInt();
		sc.nextLine();
		for(int t = 1; t <= test; t++){
			String line = sc.nextLine();
			
			String[] numbers = line.split(" ");
			
			int len = numbers.length;
			int total = 0;
			int weight[] = new int[len + 5];
			
			for(int i = 1; i <= len; i++){
			    weight[i] = Integer.parseInt(numbers[i - 1]);
			    total += weight[i];
			}
//			System.out.println(total);
			int maxWeight = total / 2;
			
			
			int arr[][] = new int[len + 5][maxWeight + 5];
			
			
		    for(int i = 0; i <= len; i++){
		        arr[i][0] = 0;
		    }
		    for(int i = 0; i <= maxWeight; i++){
		    	arr[0][i] = 0;
		    }
		    
		 for(int i= 1; i <= len; i++){
			 
			 for(int j = 1; j <= maxWeight; j++){
				 if(weight[i] > j){
					 arr[i][j] = arr[i - 1][j];
				 }
				 else{
					 arr[i][j] = Math.max(arr[i - 1][j], weight[i] + arr[i - 1][j - weight[i]]);
				 }
			 }
		 }
		    
			if(2 * arr[len][maxWeight] == total){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		
		sc.close();

	}
	



	private static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

}