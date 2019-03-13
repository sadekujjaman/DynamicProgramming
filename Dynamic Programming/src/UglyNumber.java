
public class UglyNumber {

	public static void main(String[] args) {
		
		int n = 150;
		long ans = getNthUgly(n);
		System.out.println(ans);
	}

	private static long getNthUgly(int n) {
		int ugly[] = new int[n + 1];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
	
		int next_multiple_2 = ugly[i2] * 2;
		int next_multiple_3 = ugly[i3] * 3;
		int next_multiple_5 = ugly[i5] * 5;
		
		int next_ugly_no = 0;
		
		for(int i = 1; i < n; i++){
		    next_ugly_no = Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));
		    ugly[i] = next_ugly_no;
		    if(next_ugly_no == next_multiple_2){
		    	i2++;
		    	next_multiple_2 = ugly[i2] * 2;
		    }
		    if(next_ugly_no == next_multiple_3){
		    	i3++;
		    	next_multiple_3 = ugly[i3] * 3;
		    }
		    if(next_ugly_no == next_multiple_5){
		    	i5++;
		    	next_multiple_5 = ugly[i5] * 5;
		    }
		}
		
		return next_ugly_no;
	}

}
