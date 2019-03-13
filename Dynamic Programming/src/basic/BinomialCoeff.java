package basic;

import java.util.Scanner;

public class BinomialCoeff {

	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        int k = 4;
        System.out.println(binomialCoeffDP(n, k));
        System.out.println(binomialCoeffDP_SO(n, k));
        System.out.println(binomialCoeffDP_ST(n, k));
        in.close();
    }
    // Time Complexity --> O(n*k)
    // Extra Space ------> O(n*k)
    static int binomialCoeffDP(int n, int k){
    	int arr[][] = new int[n + 1][k + 1];
    	
    	for(int i = 0; i <= n; i++){
    		for(int j = 0; j <= min(i,k); j++){
    			if(j ==0 || j == i){
    				arr[i][j] = 1;
    			}
    			else{
    				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
    			}
    		}
    	}
    	return arr[n][k];
    }
	private static int min(int i, int k) {
		return (i > k)?k:i;
	}
	
	// Space Optimization of previous code
	// Time Complexity --> O(n*k)
	// Space Complexity -> O(k)
	static int binomialCoeffDP_SO(int n, int k){
		
		int arr[] = new int[k + 1];
		// nC0 = 1
		arr[0] = 1;
		for(int i = 1; i <= n; i++){
			// compute next row of pascle
			// triangle using previous row
			for(int j = Math.min(i, k); j >0; j--){
				arr[j] = arr[j] + arr[j - 1];
			}
		}
		return arr[k];
	}
	
	// Space and Time efficient
	// Time Complexity ---> O(k)
	// Space   -----------> O(1)
	static int binomialCoeffDP_ST(int n,int k){
		int result = 1;
		// since C(n,k) = C(n, n - k)
		if(k > n - k)
			k = n - k;
		
		for(int i = 0; i < k; i++){
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}
}
