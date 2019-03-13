package lis;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class LISTwo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for(int i = 0; i  < n; i++){
			arr1[i] = sc.nextInt();
		}
		m = sc.nextInt();
		
		for(int i = 0; i < m; i++){
			arr2[i] = sc.nextInt();
			
		}
		
		LCIS();
		
		sc.close();
	}
	
	static final int MAXN = 500+3;

	static int n, m;
	static int arr1[] = new int[MAXN];
	static int arr2[] = new int[MAXN];

	static void LCIS()
	{
		
		Vector<Pair> possible[] = new Vector[m];
		
		for(int i = 0;i  < m; i++){
			possible[i] = new Vector<>();
		}
		
//	    vector<ii> possible[m];
	    int cnt[] = new int[MAXN];
	    
	    int ans = 0, idx_j = 0, idx_i = 0;

	    for(int i = 0; i < n; ++i) {
	        int mx = 0;     // max value in candidate matrix.

	        for(int j = 0; j < m; ++j) {
	            if(arr1[i] == arr2[j]) {
//	                possible[j].push_back(ii(mx+1, i));
	            	possible[j].add(new Pair(mx + 1, i));
	            	
	                cnt[j] = Math.max(cnt[j], mx+1);

	                if(cnt[j] > ans){
	                	 ans = cnt[j];
	 	                idx_i = i;
	 	                idx_j = j;
	                }
	                   
	            }
	            else if(arr1[i] > arr2[j])
	                mx = Math.max(mx, cnt[j]);
	        }
	    }

	    System.out.printf("%d\n", ans);

	    if(ans > 0) {
//	        vector<int> sol;
	    	Vector<Integer> sol = new Vector<>();
	    	
	        sol.add(arr2[idx_j]);
	        --ans;

	        for(int j = idx_j-1; j >= 0 && ans > 0; --j) {
	            if(arr2[j] < sol.get(sol.size() - 1)) {
	            	
	            	for(Pair pr : possible[j]){
	            		if(pr.first == ans && pr.second < idx_i){
	            			sol.add(arr2[j]);
	            			--ans;
	            			idx_i = pr.second;
	            			break;
	            		}
	            	}
	            }
	        }

//	        System.out.printf("%d", sol.get(sol.size() - 1));
	        
//	        for(auto it = sol.rbegin()+1; it != sol.rend(); ++it)
//	            printf(" %d", *it);
//	        putchar('\n');
	        
	        Collections.reverse(sol);
	        int si = sol.size();
	        
	        for(int i = 0; i < si - 1; i++){
	        	System.out.print(sol.get(i) + " ");
	        }
	        System.out.print(sol.get(si - 1) + "\n");
	        
	    }
	}

	private static class Pair{
		int first;
		int second;
		
		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
	}

}
