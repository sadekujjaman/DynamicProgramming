package lcs;

/**
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 */
public class LongestCommonSubstring {

    /**
     * Dynamic way of calculating lcs
     */
    public int longestCommonSubstring(char str1[], char str2[]){
        int T[][] = new int[str1.length+1][str2.length+1];
        
        int max = 0;
        int x = 0;
        int y = 0;
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(max < T[i][j]){
                        max = T[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
        }
        
        for(int i = 1; i <= str1.length; i++){
        	for(int j = 1; j <= str2.length; j++){
        		System.out.print(T[i][j] + " ");
        	}
        	System.out.println();
        }
        
        StringBuilder sb = new StringBuilder();
        x--;
        for(int i = 0; i < max; i++){
        	sb.append(str1[x]);
        	x--;
        }
        System.out.println(sb.reverse().toString());
        return max;
    }
    
    /**
     * Recursive way of calculating lcs
     */
    public int longestCommonSubstringRec(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){
            if(str1[pos1] == str2[pos2]){
                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
            }else{
                return 0;
            }
        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }
        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }
    
    public static void main(String args[]){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char str1[] = "VOTEFORTHEGREATALBANIAFORYOU".toCharArray();
        char str2[] = "CHOOSETHEGREATALBANIANFUTURE".toCharArray();
        System.out.println(lcs.longestCommonSubstring(str1, str2));
//        System.out.println(lcs.longestCommonSubstringRec(str1, str2,str1.length-1, str2.length-1,false));
    }
    
    // memory optimized
    static String LCS(String x, String y){
		int n = x.length();
		int m = y.length();
		int dp[][] = new int[2][m + 1];
		

		int b, mxlen = 0, end = 0;
		for (int i = 1; i <= n; i++)
		{
			b = i &1;
			for (int j = 1; j <= m; j++)
			{
				if (x.charAt(i - 1) == y.charAt(j - 1))
				{
					dp[b][j] = dp[1 - b][j - 1] + 1;
					if (mxlen < dp[b][j])
					{
						mxlen = dp[b][j];
						end = i;
					}
				}
			}
		}

		
		return x.substring(end - mxlen, end);
	}
}