package basic;

public class LavestheiEDITSDIST {

	public static void main(String[] args) {

		String str1 = "pantera";
		String str2 = "aorta";

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		 sb1.append(" ");
		 sb2.append(" ");
		sb1.append(str1);
		sb2.append(str2);

		int len1 = str1.length();
		int len2 = str2.length();
		char[] chars1 = sb1.toString().toCharArray();
		char[] chars2 = sb2.toString().toCharArray();

		int dist[][] = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			dist[i][0] = i;
		}
		for (int i = 0; i <= len2; i++) {
			dist[0][i] = i;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				 int edit = 1;
				 if(chars1[i] == chars2[j]){
				 edit = 0;
				 }
				 dist[i][j]=Math.min(dist[i - 1][j] + 1, // deletion
				 Math.min(dist[i][j - 1] + 1, //insertion
				 dist[i - 1][j - 1] + edit)); // substitution
				
				// if i > 1 and j > 1 and a[i] = b[j-1] and a[i-1] = b[j] then
				// d[i, j] := minimum(d[i, j],
				// d[i-2, j-2] + cost)
				// swaping
//				 if(i > 1 && j > 1 && (chars1[i] == chars2[j - 1]) &&
//				 (chars1[i - 1] == chars2[j ]) ){
//				 dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] +edit);
//				 }
//				 
				 
					for (int k = i - 1; k > 0; k--) {
						if (chars1[i] == chars2[j - 1] && chars1[k] == chars2[j] && j >= 2) {
							dist[i][j] = Math.min(dist[i][j], dist[k - 1][j - 2] + (i - k - 1) + 1);
						}
					}
			}
		}

		System.out.println(dist[len1][len2]);

		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

}
