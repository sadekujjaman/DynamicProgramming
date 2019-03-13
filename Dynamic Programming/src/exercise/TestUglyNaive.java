package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestUglyNaive {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,8,9,10};
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int i = 0; i < test; i++){
			int num = sc.nextInt();
			int ans = calculate(arr, num);
			System.out.println(ans);
		}
		sc.close();
	}

	private static int calculate(int[] arr, int num) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= num; i++){
			boolean flag = false;
			for(int j = 0; j < arr.length; j++){
				if(i % arr[j] == 0){
					flag = true;
					break;
				}
			}
			if(!flag)
				list.add(i);
		}
		return list.size();
	}

}
