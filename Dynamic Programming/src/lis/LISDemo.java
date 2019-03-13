package lis;

import java.util.Scanner;
import java.util.Vector;

public class LISDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Vector<Integer> vector = new Vector<>();
		
		for(int i = 0; i < n; i++){
			vector.add(sc.nextInt());
		}
		
		calculateLIS(vector);
		
		sc.close();
		
	}

	private static void calculateLIS(Vector<Integer> D) {
		int n = D.size();
		Vector<Integer> L[] = new Vector[n];
		for(int i = 0; i < n; i++){
			L[i] = new Vector<>();
		}
		
		L[0].add(D.get(0));
		
		int max = -1;
		
		for(int i = 1; i < n; i++){
			
			for(int j = 0; j < i; j++){
				
				if(D.get(j) < D.get(i) && L[i].size() < L[j].size() + 1){
					L[i] = new Vector<>(L[j]);
				}
				
				
			}
			L[i].add(D.get(i));
			if(max < L[i].size()){
				max = L[i].size();
			}
		}
		
		for(Vector<Integer> v : L){
			for(Integer i : v){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		System.out.println(max);
		
	}

}
