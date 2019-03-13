package basic;

import java.util.Collection;
import java.util.Vector;

public class LISVECTOR {

	public static void main(String[] args) {
		int[] array = {2, 6, 4, 5, 1,3 };

		System.out.println("Data In");
		calc_LIS(array);
	}

	static void calc_LIS(int nums[]) {
		String paths[] = new String[nums.length];
		int sizes[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			paths[i] = nums[i] + " ";
			sizes[i] = 1;
		}
		int maxL = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && sizes[i] < sizes[j] + 1) {
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + nums[i] + " ";
					System.out.println(paths[i]);
					if (maxL < sizes[i])
						maxL = sizes[i];
				}
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (sizes[i] == maxL)
				System.out.println(paths[i]);
		}
	}

}
