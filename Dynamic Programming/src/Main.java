
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(210 / 4);
		int test = sc.nextInt();

		for (int t = 1; t <= test; t++) {
			BigInteger num = sc.nextBigInteger();

			BigInteger ans = calculate1(num);
			System.out.println(ans);

		}
		sc.close();
	}

	private static BigInteger calculate1(BigInteger num) {
		BigInteger ans = BigInteger.ZERO;
		for (long i = 1; i < 211; i++) {
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
				ans = ans.add(BigInteger.ONE);
			}
		}
		
		BigInteger x = num.divide(BigInteger.valueOf(210));// num / 210;
		ans = ans.multiply(x);//ans * x;
//		for (BigInteger i = x.multiply(BigInteger.valueOf(210)); i.compareTo(num) < 1; i=i.add(BigInteger.ONE)) {
//			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
//				ans++;
//			}
//		}
		
		for(BigInteger i = x.multiply(BigInteger.valueOf(210)); i.compareTo(num) < 1; i = i.add(BigInteger.ONE)){
			if(!i.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) &&
			   !i.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO) &&
			   !i.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) &&
			   !i.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO)){
				//System.out.println(i + " " + "not");
				ans = ans.add(BigInteger.ONE);
			}
		}
		
		return ans;
	}

}
