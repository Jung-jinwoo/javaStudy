package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액: ");
		int price = scanner.nextInt();
		
		int p,q;
		int []cnt = new int[MONEYS.length];
		
		for(int i=0; i<MONEYS.length; i++) {
			p = price/MONEYS[i];
			q = price%MONEYS[i];
			cnt[i] = p;
			price = price - MONEYS[i]*p;
		}
		
		for(int i=0; i<cnt.length; i++) {
			System.out.println(MONEYS[i] + "원 : " + cnt[i] + "개");
		}
		scanner.close();
 	}
}