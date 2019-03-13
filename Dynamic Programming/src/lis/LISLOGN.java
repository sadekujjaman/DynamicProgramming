package lis;

import java.util.Arrays;
import java.util.Scanner;

public class LISLOGN {

	static int n;
	static final int INF = 2000000000;
	static final int SIZE = 50;

	static int[] sequence = new int[SIZE];
	static int[] L = new int[SIZE];
	static int[] I = new int[SIZE + 1];
	static int[] lisSequence = new int[SIZE];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			sequence[i] = sc.nextInt();
		}

		Arrays.fill(I, INF);
		I[0] = -INF;
		Arrays.fill(L, -1);

		int result = LISCount();
		System.out.println(result);
		
		System.out.println();
//		findSequence(result);
		sc.close();
	}

	private static int LISCount() {

		int lisLength = 0;
		for (int i = 0; i < n; i++) { // iterate left to right

			int low, high, mid; // variables to perform binary search

			low = 0; // minimum position where we to put data in I[]

			high = lisLength; // the maximum position

			while (low <= high) { // binary search to find the correct position

				mid = (low + high) / 2;

				if (I[mid] < sequence[i])

					low = mid + 1;

				else

					high = mid - 1;

			}
			I[low] = sequence[i];

			if (lisLength < low)
				lisLength = low;

//			System.out.println(lisLength);
		}
		
		
		return lisLength;

	}

	static void findSequence(int maxLength) {

		int i, j; // variable used for iteration
		// at first find the position of the item whose L[] is maximum

		i = 0;

		for (j = 1; j < n; j++) {

			if (L[j] > L[i])
				i = j;

		}

		// initialize the position in LisSequence where the items can be added.

		// observe that the data are saving from right to left!

		int top = L[i] - 1;

		// insert the item in i-th position to LisSequence

		lisSequence[top] = sequence[i];

		top--; // is decreasing such that a new item can be added in a new place

		// now find the other valid numbers to form the sequence

		for (j = i - 1; j >= 0; j--) {

			if (sequence[j] < sequence[i] && L[j] == L[i] - 1) {

				// we have found a valid item so, we will save it

				i = j; // as in our algorithm

				lisSequence[top] = sequence[i]; // stored

				top--; // decreased for new items

			}

		}

		// so, we have got the sequence, now we want to print it

		System.out.print("LIS is: ");

		for (i = 0; i < maxLength; i++) {

			System.out.print(lisSequence[i] + " ");

		}
	}

}
