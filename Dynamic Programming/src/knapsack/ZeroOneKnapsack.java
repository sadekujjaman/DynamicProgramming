package knapsack;

import java.util.*;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		
		int profit[] = {0, 1, 2, 5, 6};
		int weight[] = {0, 2, 3, 4, 5};
		int n = 4;
		int m = 8;
		
//		int profit[] = {0, 60, 100, 120};
//		int weight[] = {0, 10, 20, 30};
//		int n = 3;
//		int m = 50;
		
//		int profit[] = {0, 72, 44, 31};
//		int weight[] = {0, 17, 23, 24};
//		int n = 3;
//		int m = 26;
		
//		int profit[] = {0, 64, 85, 52, 99, 39, 54};
//		int weight[] = {0, 26, 22, 4, 18, 13, 9};
//		int n = 6;
//		int m = 26;
		
		int table[][] = new int[n + 1][m + 1];
		
		for(int i = 0; i <= n; i++){
			for(int w = 0; w <= m; w++){
				if(i == 0 || w == 0){
					table[i][w] = 0;
				}
				else if(weight[i] <= w){
					table[i][w] = Math.max(profit[i] + table[i - 1][w - weight[i]] , 
							table[i - 1][w]);
				}
				else{
					table[i][w] = table[i - 1][w];
				}
			}
		}
		int i = n;
		int weightLeft = m;
		int value = 0;
//		while(i > 0 ){
//			if(table[i][weightLeft] == table[i - 1][weightLeft]){
//				System.out.println("Not Include " + i);
//			}
//			else{
//				System.out.println("Include " + i);
//				weightLeft -= weight[i];
//				value += profit[i];
//			}
//			i--;
//		}
//		System.out.println(value);
		
		
		// printing value
		List<Integer> list = new ArrayList<>();
	    
	    while(i > 0 && weightLeft > 0){
	        if(table[i][weightLeft] != table[i - 1][weightLeft]){
	            value += profit[i];
	            weightLeft -= weight[i];
	            list.add(weight[i]);
	            
	        }
	        i--;
	    }
	    System.out.println(value);
	    System.out.print("Items: ");
	    for(Integer e : list){
	        System.out.print(e + " ");
	    }
	    System.out.println();
		
		
	}

}
