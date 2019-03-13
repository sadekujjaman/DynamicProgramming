package tabulation;

import java.util.Date;

// Bottom-Up Approach
public class Fibonacci {

	static int fib(int n){
		int[] lookup = new int[n + 5];
		lookup[0] = 0;
		lookup[1] = 1;
		
		for(int i = 2; i <= n; i++){
			lookup[i] = lookup[i - 1] + lookup[i - 2];
		}
		return lookup[n];
	}
	
	public static void main(String[] args) {
		System.out.println("FIB: " + fib(40));
		
	}

}
