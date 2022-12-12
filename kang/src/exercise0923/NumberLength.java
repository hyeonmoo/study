package exercise0923;

import java.util.Scanner;

public class NumberLength {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("수를 입력하시오: ");
		int number = sc.nextInt();
		int numLength=0;
		while(number!=0) {
			numLength++;
			number/=10;
		}
		System.out.println("자릿수: "+numLength);
		sc.close();
	}
}
