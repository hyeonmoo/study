package exercise0923;

import java.util.Scanner;

public class Aliquot {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.print("수를 입력: ");
		int number=sc.nextInt();
		for(int i=1;i<=number;i++) {
			if(number%i==0) sb.append(i+" ");
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
