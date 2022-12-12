package exercise.print;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력> ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			int cnt = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) cnt++;			
			}
			if(cnt==2) System.out.printf("%d ",i);
		}
		sc.close();
	}
}
