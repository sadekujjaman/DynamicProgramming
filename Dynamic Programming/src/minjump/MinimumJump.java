package minjump;

import java.util.Arrays;
// time -> O(N^2)

public class MinimumJump {
	final static int INF = 999999999;
	static int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};// { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };
	static int[] minJump = new int[arr.length];
	static int[] from = new int[arr.length];

	public static void main(String[] args) {

		
		from[0] = -1;
		Arrays.fill(minJump, INF);
		minJump[0] = 0;
		int ans = minjump();
		System.out.println("Min: " + ans);
		for(int i = 0; i < arr.length; i++){
			System.out.print(minJump[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++){
			System.out.print(from[i] + " ");
		}
		System.out.println();
		int start = arr.length - 1;
		while(start != -1){
			System.out.print(start + "<-");
			start = from[start];
		}

	}

	private static int minjump() {

		for (int i = 1; i < arr.length; i++) {
             for(int j = 0; j < i; j++){
            	 if(i <= j + arr[j] && minJump[j] != INF){
            		// minJump[i] = Math.min(minJump[i], minJump[j] + 1);
            		 int value = minJump[j] + 1;
            		 if(value < minJump[i]){
            			 minJump[i] = value;
            			 from[i] = j;
            		 }
            		 break;
            	 }
             }
		}

		return minJump[arr.length - 1];
	}

}
