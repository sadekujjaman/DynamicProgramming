package basic;

import java.util.Scanner;

public class Combination {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int result = combination(n,r);
		System.out.println(result);
		sc.close();
	}

	static int[][] combinationTable = new int[5000][5000];
	private static int combination(int n, int r) {
		if(r == 0 || n == r){
			//combinationTable[n][r] = 1;
			return 1;// combinationTable[n][r];
		}
		if(combinationTable[n][r] == 0)
		    combinationTable[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
		return combinationTable[n][r];
	}

}
