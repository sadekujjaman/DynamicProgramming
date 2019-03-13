package basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LCSOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 0; i < test; i++){
			String str = sc.next();
			//int ans = maxSequence(str);
			Set<Character> set = new HashSet<>();
			for(char c: str.toCharArray()){
				set.add(c);
			}
			
			System.out.println(set.size());
		}
		sc.close();
	}
	
	static int maxSequence(String str){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 97; i <= 122; i++){
			map.put((char)i, 0);
		}
		int max = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(map.get(c) == 0)
			{
				max++;
				map.put(c, 1);
			}
		}
		return max;
	}

}
