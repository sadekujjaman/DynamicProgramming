package basic;

import java.util.Arrays;
import java.util.Scanner;

public class SPOJELIS {

	private static int MAX = 15;
	private static int N = 0;
	private static int arr[] = new int[MAX];
	private static int dp[] = new int[MAX];
	private static int dir[] = new int[MAX];
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		Arrays.fill(dp, -1);
		Arrays.fill(dir, -1);
		N = sc.nextInt();
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
		}
		
		int lis = 0; 
		int start = 0;
		
		for(int i = 1; i <= N; i++){
			int temp = longest(i);
			if(temp > lis){
				lis = temp;
				start = i;
			}
		}
		//print_lis(start);
		System.out.println(lis);
		sc.close();
	}


	

	private static int longest(int u) {
		if(dp[u] != -1)
			return dp[u];
		
		int max = 0;
		for(int v = u + 1; v <= N; v++){
			if(arr[v] > arr[u]){
				int temp = longest(v);
				if(temp > max){
					max = temp;
					dir[u] = v;
				}
			}
		}
		return dp[u] = 1 + max;
	}
private static void print_lis(int start) {
		
	while(dir[start] != -1){
		System.out.print(arr[start] + " ");
		start = dir[start];
	}
	System.out.print(start + "\n");
		
	}


}
