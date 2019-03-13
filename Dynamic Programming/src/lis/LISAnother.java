package lis;

import java.io.*;
import java.util.*;

public class LISAnother {

	static final int S = 100006;

	static int R[] = new int[S];/* Generated Table */
	static int A[] = new int[S];/* Input data */
	static int Indx[] = new int[S]; /* Index of the Table Element */
	static int Pre[] = new int[S]; /* Previous Element */

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);

		int i, v = 0;
		int rc;
		int s, e, mid;/* Binary Search */

		A[0] = R[0] = Integer.MIN_VALUE;
		Indx[0] = 0;
		i = 1;
		rc = 1;
		String str = "";
		// BufferedReader objReader = new BufferedReader(new
		// FileReader("G:\\Program Files\\Java Program\\Eclipse\\Dynamic
		// Programming\\src\\lis\\uvainput.txt"));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// StringBuffer pr = new StringBuffer("");

		while ((str = input.readLine()) != null) {
			System.out.println(str);
			// if(str.length() == 0)
			// break;
			int a = Integer.parseInt(str);
			A[i] = a;
			v = A[i];
			if (v > R[rc - 1]) {
				R[rc] = v;
				Indx[rc] = i;
				Pre[i] = Indx[rc - 1];
				rc++;
			} else if (v < R[rc - 1]) {/* Binary Search */
				mid = BinarySearch(v, 1, rc - 1);
				R[mid] = v;
				Indx[mid] = i;
				Pre[i] = Indx[mid - 1];
			}
			i++;

		}

		System.out.printf("%d\n-\n", rc - 1);
		i = Indx[rc - 1];
		Print(i);
		
		
		for(int j = 0; j <= 5; j++){
			System.out.print(R[j] + " ");
		}
		System.out.println();
		input.close();
	}

	static void Print(int i) {
		if (i == 0)
			return;
		else {
			Print(Pre[i]);
			System.out.printf("%d\n", A[i]);
		}
		return;
	}

	/* Complexity lg2^N */
	static int BinarySearch(int v, int start, int end) {
		int mid = 0;
		while (start <= end) {
			mid = start + ((end - start) / 2);
			if (v <= R[mid]) {
				if (R[mid - 1] < v)
					break;
				end = mid - 1;
			} else if (v > R[mid]) {
				if (R[mid + 1] >= v) {
					mid = mid + 1;
					break;
				}
				start = mid + 1;
			}
		}
		return mid;
	}

}
