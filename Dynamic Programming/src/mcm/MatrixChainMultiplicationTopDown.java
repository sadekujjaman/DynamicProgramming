package mcm;

import java.util.Arrays;

public class MatrixChainMultiplicationTopDown
{

    static int dp[][];
    
	public static int matrixChainMultiplication(int[] dims, int i, int j)
	{
            
		if (j <= i + 1) {
			return 0;
		}

                if(dp[i][j] != -1)
                    return dp[i][j];
		int min = Integer.MAX_VALUE;

		

                int index = 0;
		for (int k = i + 1; k <= j - 1; k++)
		{
			System.out.println("F " + i + " " + k);
			System.out.println("S " + k + " " + j);
			int cost = matrixChainMultiplication(dims, i, k);

			cost += matrixChainMultiplication(dims, k, j);

			cost += dims[i] * dims[k] * dims[j];

			System.out.println("C: " + cost);
			if (cost < min) {
				min = cost;
                                index = k;
			}
			
			
		}
		System.out.println("E");

//                if(index - i == 1){
//                    printAnswer(i, index);
//                }
//                else{
//                    System.out.print("(");
//                    printAnswer(index, j);
//                    System.out.print(")");
//                }
                
		return dp[i][j] = min;
	}

//         private static void printAnswer(int i, int index) {
//      
//             System.out.print("*");
//    }
	public static void main(String[] args)
	{
		int[] dims = { 10, 5, 2, 20, 12};

                dp = new int[dims.length + 1][dims.length + 1];
                for(int i = 0; i <= dims.length; i++){
                    Arrays.fill(dp[i], -1);
                }
		System.out.println("Cost is " +
				matrixChainMultiplication(dims, 0, dims.length - 1));
                
//                for(int i = 0; i < dims.length; i++){
//                    for(int j = 0; j < dims.length; j++){
//                        System.out.print(dp[i][j] + " ");
//                    }
//                    System.out.println();
//                }
                
	}

   
}