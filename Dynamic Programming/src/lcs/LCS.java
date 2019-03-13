package lcs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LCS {

	static int dpTopDown[][];
	static int dpBottomUp[][];
	
	static String lcs[][] = new String[105][105];
	
	public static void main(String[] args) {
		System.out.println("Saju");

		
		String str1 = "abcabcaa";
		String str2 = "acbacba";

		// String str1 = "%shahjahan";
		// String str2 = "%momtaj";

		int m = str1.length();
		int n = str2.length();

		dpBottomUp = new int[m + 1][n + 1];

		System.out.println("Bottom Up");
		System.out.println(lcsBottomUp(m, n, str1, str2));
		
		System.out.println();
		
		// get all the solution from Bottom up
		
		Set<String> sets = findAllLCS(str1, str2, m, n);
		for(String str : sets){
			System.out.println(str);
		}
		//
		

		String str3 = "abcde";
		String str4 = "acde";
		m = str3.length();
		n = str4.length();
		
		dpTopDown = new int[m + 5][n + 5];
		for(int i = 0; i <= m + 2; i ++){
			Arrays.fill(dpTopDown[i], -1);
		}
		System.out.println("Top Down");
		System.out.println(lcsTopDown(0, 0, str3, str4));
	}

	private static void callForMinLCS(String str1, String str2) {
		String ns1 = "." + str1;
		String ns2 = "." + str2;

		int m = str1.length();
		int n = str2.length();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (ns1.charAt(j) == ns2.charAt(i)) {

					lcs[i][j] = lcs[i - 1][j - 1] + ns1.charAt(j);
				} else {
					String str = LCSCompare(lcs[i - 1][j], lcs[i][j - 1]);
					lcs[i][j] = str;
				}
			}
		}
	}
	
	private static String LCSCompare(String string1, String string2) {
		int m = string1.length();
		int n = string2.length();
		
		if (m == n) {

			if (string1.compareTo(string2) > 0) {
				return string2;
			} else {
				return string1;
			}
		} else {
			if (m > n)
				return string1;
			else
				return string2;
		}
	}

	private static Set<String> findAllLCS(String str1, String str2, int m, int n) {
		
		Set<String> set = new HashSet<>();
		
		if(m == 0 || n == 0)
		{
			set.add("");
			return set;
		}
		
		if(str1.charAt(m - 1) == str2.charAt(n - 1)){
			Set<String> temp = findAllLCS(str1, str2, m - 1, n - 1);
			
			for(String str : temp){
				String s = String.valueOf(str1.charAt(m - 1));
				set.add(str + s);
			}
			
		}
		else{
			if (dpBottomUp[m - 1][n] >= dpBottomUp[m][n - 1]) 
	            set = findAllLCS(str1, str2, m - 1, n); 
	  
	        // If LCS can be constructed from left side of 
	        // the matrix, recurse for X[0..m-1] and Y[0..n-2] 
	        if (dpBottomUp[m][n - 1] >= dpBottomUp[m - 1][n]) 
	        { 
	            Set<String> tmp = findAllLCS(str1, str2, m, n - 1); 
	  
	            // merge two sets if L[m-1][n] == L[m][n-1] 
	            // Note s will be empty if L[m-1][n] != L[m][n-1] 
	            set.addAll(tmp);
	            
	        } 
		}
		
		return set;
	}

	static int lcsBottomUp(int m, int n, String str1, String str2){
		
		for (int i = 0; i <= m; i++) {

			for (int j = 0; j <= n; j++) {
				if(i == 0 || j == 0){
					dpBottomUp[i][j] = 0;
					continue;
				}
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dpBottomUp[i][j] = 1 + dpBottomUp[i - 1][j - 1];
				} else {
					dpBottomUp[i][j] = Math.max(dpBottomUp[i - 1][j], dpBottomUp[i][j - 1]);
				}
			}

		}
		
     // print Solution
		printLCS(m, n, str1, str2, dpBottomUp);
		
		return dpBottomUp[m][n];
	}
	
	static int lcsTopDown(int i, int j, String x, String y) {
		
		int sol1, sol2, sol3;

		
		if (i == x.length() || j == y.length()) {
			
			return 0;
		}

		if(dpTopDown[i][j] != -1)
			return dpTopDown[i][j];
		
		
		if(x.charAt(i) == y.charAt(j)){
			sol1 = lcsTopDown(i + 1, j + 1, x, y);
			return dpTopDown[i][j] = (sol1 + 1);
		} else {
			sol2 = lcsTopDown(i + 1, j, x, y);
			sol3 = lcsTopDown(i, j + 1, x, y);

			return dpTopDown[i][j] = Math.max(sol2, sol3);
		}
	}

	private static void printLCS(int m, int n, String str1, String str2, int[][] dp) {
		int i = m, j = n; 
		int count = dpBottomUp[m][n];
		
		StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) 
        { 
            
            if (str1.charAt(i-1) == str2.charAt(j-1)) 
            { 
                  sb.append(String.valueOf(str1.charAt(i - 1)));
                i--;  
                j--;  
                count--;      
            } 
   
            else if (dpBottomUp[i-1][j] > dpBottomUp[i][j-1]) 
                i--; 
            else
                j--; 
        } 
			
	

		System.out.println(sb.reverse().toString());

	}
}
