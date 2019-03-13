package knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		
	    Scanner sc = new Scanner(System.in);
	   
	    int itemNo = 7;
	    int maxWeight = 15;
	    int profit[] = {10, 5, 15, 7, 6, 18, 3};
	    int weight[] = {2, 3, 5, 7, 1, 4, 1};
	    
	    Double pperw[] = new Double[itemNo];
	    Tut[] tut = new Tut[itemNo];
	    
	    for(int i = 0; i < profit.length; i++){
	    	pperw[i] = (double)profit[i] / weight[i];
	    	tut[i] = new Tut(i, pperw[i]);
	    }
	    
	    Arrays.sort(tut, new Sorted());
	    
	    for(int i = 0; i < tut.length; i++){
	    	//System.out.println(tut[i].pperw + " " + tut[i].index);
	    }
	    
	    System.out.println();
	    
	    int weightLeft = maxWeight;
	    double include[] = new double[itemNo];
	    
	    for(int i = 0; i < itemNo; i++){
	         Tut t = tut[i];
	        // System.out.println(tut[i].pperw + " " + tut[i].index);
	         int index = t.index;
	         if(weightLeft >= weight[index]){
	        	 weightLeft -= weight[index];
	        	 include[index] = 1;
	         } 
	         else if(weightLeft < weight[index]){
	        	 include[index] = (double)weightLeft/weight[index];
	        	 weightLeft = 0;
	         }
	        // System.out.println(include[index] + " " + weightLeft);
	    }
	    
	    double totalProfit= 0;
	    double totalWeight = 0;
	    for(int i = 0; i < include.length; i++){
	    	System.out.print(include[i] + " ");
	    	if(include[i] != 0){
	          	totalWeight += (double)weight[i] * include[i];
	          	totalProfit += profit[i];
	    	}
	    }
	    System.out.println();
	    System.out.println(totalProfit + " " + totalWeight);
	    
	    sc.close();
	}

}

class Tut{
	double pperw;
	int index;
	public Tut(int index, double pperw) {
		this.index = index;
		this.pperw = pperw;
	}
}

