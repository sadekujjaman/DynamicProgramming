package mcm;

public class MatrixChainMultiplicationBottomUpAndSolutionPrint {

    public static int[] p = {40, 20, 30, 10, 30};  
    protected static int m[][];
    protected static int s[][];
    protected static int n;

    public static void main(String[] args) {

        System.out.println("The optimal parenthesization for those matrices costs: " + matrixChainOrder());
        System.out.println();
//        printOptimalParens(s, 0, n - 1);
//        System.out.println("");
//        
//        for(int i = 0; i <= p.length; i++){
//        	for(int j = 0; j < p.length; j++){
//        		System.out.print(m[i][j] + " ");
//        	}
//        	System.out.println();
//        }
    }

    public static int matrixChainOrder() {
//        n = p.length - 1;
//        m = new int[n + 5][ n + 5];
//        s = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            m[i][i] = 0;
//        }
//
//        for (int row = 1; row < n; row++) {
//            for (int i = 0; i < n - row; i++) {
//                int j = i + row;
//                m[i][j] = Integer.MAX_VALUE;
//                for (int k = i; k < j; k++) {
//                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
//                    if (k == i) {
//                        m[i][j] = q;
//                        s[i][j] = k;
//                    } else if (k == i + 1) {
//                        if (m[i][j] > q) {
//                            m[i][j] = q;
//                            s[i][j] = k;
//                        }
//                    } else {
//                        if (q < m[i][j]) {
//                            m[i][j] = q;
//                            s[i][j] = k;
//                        }
//                    }
//                }
//
//                if (row == p.length - 2) { 
//                    return m[i][j]; 
//                }
//            }
//        }
//        return -1; 
    	
    	int n = p.length;
    	int inf = 1000000000;
    	m = new int[n][n];
    	for(int i = 1; i < n; i++){
    		for(int j = i - 1; j >= 0; j--){
    			if(i - j == 1){
    				m[j][i] = 0;
    			}
    			else{
    				m[j][i] = inf;
    				for(int k = j; k <= i; k++){
    					m[j][i] = Math.min(m[j][i], m[j][k] + (p[j] * p[k] * p[i]) + m[k][i]); 
    				}
    			}
    		}
    	}
    	
    	System.out.println();
    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < n; j++){
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	return m[0][n - 1];
    }

    static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print((i + 1));
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
