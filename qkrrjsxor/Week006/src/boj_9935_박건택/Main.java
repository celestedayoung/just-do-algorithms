package boj_9935_박건택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] charArr = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		List<Character> list = new ArrayList<>();

		int charLen = charArr.length;
		int bombLen = bomb.length;

		for (int i = 0; i < charLen; i++) {
			list.add(charArr[i]);
		}
		int k;

		loop: for (int i = charLen - bombLen; i >= 0; i--) {
//			System.out.println(charArr[i]);
			k = 0;
			
			for (int t = i; t < i + bombLen; t++) {
//					System.out.println("k : " + k + " t : " + t + " v : " + list.get(t));
				if (charArr[t] != bomb[k]) {
//						System.out.println("go loop");
					continue loop;
				}
				k++;
			}
			

			if (k == bombLen) {
				for (int t = 0; t < bombLen; t++) {
//					System.out.println("remove : " + list.get(i));
					charArr[t] = ' ';
				}
			}

		}

		if (list.size() == 0) {
			System.out.println("FRULA");
		} else {
			for (int i = 0; i < charLen; i++) {
				if(charArr[i] != ' ') {
					
					sb.append(charArr[i]);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
