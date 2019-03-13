package tabulation;

import java.util.Arrays;
//
// (1,3,5) = n -> how many form
public class SumOfArrangeMent {

	
	static int countArrangement(int n){
		int lookup[] = new int[n+5];
		
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
		System.out.println("Arrange: " + countArrangement(7));
	}

}
