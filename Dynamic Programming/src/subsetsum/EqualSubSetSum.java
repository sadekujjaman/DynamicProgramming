package subsetsum;

import java.util.Scanner;

public class EqualSubSetSum {

	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
			
			int n = sc.nextInt();
			int[] coins = new int[n];
			
			int sum = 0;
			
			for(int i = 0; i < n; i++){
				coins[i] = sc.nextInt();
				sum += coins[i];
			}
			
			if(sum % 2 == 0 && isEqualSum(0, coins, sum  / 2)){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		
		}
		
		sc.close();
	}
	
	private static boolean isEqualSum(int i, int[] coins, int sum) {
		
		if(sum == 0)
			return true;
		if(i >= coins.length || sum < 0)
			return false;
		
		return isEqualSum(i + 1, coins, sum - coins[i]) || isEqualSum(i + 1, coins, sum);
		
	}

}
