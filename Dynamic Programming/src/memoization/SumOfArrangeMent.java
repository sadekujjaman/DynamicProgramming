package memoization;

import java.util.Arrays;
//
// (1,3,5) = n -> how many form
public class SumOfArrangeMent {

	static int MAX = 100;
	final int NIL = -1;
	
	static int[] lookup = new int[MAX];
	
	static void initialize(){
		Arrays.fill(lookup, -1);
	}
	
	static int countArrangement(int n){
		
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		if(lookup[n] == -1)
		    return lookup[n] =countArrangement(n - 1)
				+countArrangement(n -3)
				+ countArrangement(n - 5);
		
		return lookup[n];
		
	}
	public static void main(String[] args) {
		initialize();
		System.out.println("Arrange: " + countArrangement(5));
	}

}
