package basic;

public class LIS {

	public static void main(String[] args) {
		int arr[] = {50, 3, 10, 7, 40, 80};
		int val = lis(arr, arr.length);
		int vald = lisDyn(arr);
		System.out.println(val);
		System.out.println(vald);
	}
	static int myMax = 1;
	static int lis(int arr[], int n){
		
		int res, max_ending_here = 1;
		
		for(int i = 1; i < n; i++){
			res = lis(arr, i);
			if(arr[i - 1] < arr[n - 1] && (res + 1) > max_ending_here)
				max_ending_here = res + 1;
		}
		
		if(myMax < max_ending_here)
			myMax = max_ending_here;
		
		return max_ending_here;
	
	}
	
	// Time Complexity --> O(n^2)
	
	static int lisDyn(int array[]){
		int i,j,max = 0;
		int lis[] = new int[array.length];
		int n = array.length;
		// Initialize LIS values for all indexes 
		for(int k = 0; k < lis.length; k++){
			lis[k] = 1;
		}
		// Compute optimized LIS values in bottom up manner
		for(i = 1; i < n; i++){
			for(j = 0; j < i; j++){
				if(array[i] > array[j] && lis[i] < lis[j] + 1){
					lis[i] = lis[j] + 1;
				}
			}
		}
		// Pick maximum of all LIS values 
		for(i = 0; i < lis.length; i++){
			if(max < lis[i])
				max = lis[i];
		}
		return max;
	}

}
