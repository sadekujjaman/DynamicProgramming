package lis;

import java.util.*;

public class UVAWavio_Sequence {

	final static int ASC = 0, DSC = 1;

	public static void main(String... args) {
		try {
			Scanner sc=new Scanner(System.in);
			while(sc.hasNext()) {
				int N = sc.nextInt();
				int[] arr = new int[N];
				for (int i = 0; i < N; i++) {
					arr[i] = sc.nextInt();
				}
				int ans = getAns(N, arr);
				System.out.println(ans);
				
			}
			sc.close();
		} catch (Exception e) {
			// Nothing to do here
		} finally {
			
			System.exit(0);
		}
	}

	static int getAns(int N, int[] arr) {
		int[] incr = LIS(N, arr);
		
		for(int i = 0; i < incr.length; i++){
			System.out.print(incr[i] + " ");
		}
		
		System.out.println();
		
		arr = reverse(arr, N);
		int[] decr = LIS(N, arr);
		for(int i = 0; i < decr.length; i++){
			System.out.print(decr[i] + " ");
		}
		System.out.println();
		decr = reverse(decr, N);
		for(int i = 0; i < decr.length; i++){
			System.out.print(decr[i] + " ");
		}
		System.out.println();

		int ans = 0;
//		1 2 2 2 3 4 4 4 
//		1 4 3 1 1 2 2 1
		
		for (int i = 0; i < N; i++) {
			ans = Math.max(2 * Math.min(incr[i], decr[i]) - 1, ans);
		}
		return ans;
	}

	static int[] LIS(int N, int[] arr) {
		// LIS[i] stores the maximum length of S's LIS ending at i.
		int[] L = new int[N];
		int[] I = new int[N+1];

		I[0] = Integer.MIN_VALUE;
		for (int i = 1; i < N+1; i++) {
			L[i-1] = 1;
			I[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < N+1; i++) {
			int low, mid, high;
			low = 0;
			high = i;
			while (low <= high) {
				mid = (low + high) / 2;
				if (I[mid] < arr[i-1])
					low = mid + 1;
				else
					high = mid - 1;
			}
			I[low] = arr[i-1];
			L[i-1] = low;
		}
//
//		for(int i = 0; i < N + 1; i++){
//			System.out.print(I[i] + " ");
//		}
//		System.out.println("H");
		return L;
	}

	
	static int[] reverse(int[] arr, int N) {
		int[] ans = new int[N];
		for (int i = 0; i < N; i++)
			ans[N-i-1] = arr[i];
		return ans;
	}
}