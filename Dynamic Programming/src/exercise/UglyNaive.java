package exercise;

public class UglyNaive {

	public static void main(String[] args) {
		
		int n = 150;
		int ans = getNthUgly(n);
		System.out.println(ans);
	}

	private static int getNthUgly(int n) {
		int count = 1;
		int num = 1;
		while(count < n){
			num++;
			if(isUgly(num))
				count++;
		}
		
		return num;
	}

	private static boolean isUgly(int num) {
		int no = num;
		no = getMaxDivide(no, 2);
		no = getMaxDivide(no, 3);
		no = getMaxDivide(no, 5);
		if(no == 1)
			return true;
		return false;
	}

	private static int getMaxDivide(int no, int i) {
		while(no % i == 0){
			no = no / i;
		}
		return no;
	}

}
