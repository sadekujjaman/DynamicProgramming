package memoization;

import java.util.Arrays;

// Top-Down Approach
public class Fibonacci
{
  final int MAX = 100;
  final int NIL = -1;
 
  int lookup[] = new int[MAX];
 
  void initialize(){
	  Arrays.fill(lookup, NIL);
  }
  
  int fib(int n){
	  if(lookup[n] == NIL){
		  if(n <= 1)
			  lookup[n] = n;
		  else{
			  lookup[n] = fib(n - 1) + fib(n - 2);
		  }
	  }
	  return lookup[n];
  }
 
  public static void main(String[] args)
  {
    Fibonacci f = new Fibonacci();
    int n = 10;
    f.initialize();
    System.out.println("Fibonacci number is" + " " + f.fib(n));
  }
 
}