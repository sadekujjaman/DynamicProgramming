package basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci1(n) % 100000007);
		sc.close();
	}
	// Time Complexity: O(n)
	// Extra Space: O(n)
   static long fibonacci(int n){
	   long fibArr[] = new long[n + 1];
	   fibArr[0] = 0;
	   fibArr[1] = 1;
	   for(int i = 2; i <= n; i++){
		   fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
	   }
	   
	   return fibArr[n];
   }
   
// Java program for Fibonacci Series using Space
// Optimized Method
// Time Complexity: O(n)
// Extra Space: O(1)
   static long fibonacci1(int n){
	   long a = 0;
	   long b = 1;
	   long c;
	   if(n == 0)
		   return a;
	   for(int i = 2; i <= n; i++){
		  c = a + b;
		  a = b;
		  b = c;
	   }
	   return b;
	   
   }

   static BigInteger fibonacciModified(int t1, int t2, int n) {
       BigInteger a = BigInteger.valueOf(t1);
       BigInteger b = BigInteger.valueOf(t2);
       BigInteger c = BigInteger.valueOf(0);
       BigInteger d = BigInteger.valueOf(0);
       for(int i = 2; i < n; i++){
           c = a.add(b.multiply(b));
           a = b;
           b = c;
       }
       return (b);
   }
}
