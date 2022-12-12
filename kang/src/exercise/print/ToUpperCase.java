package exercise.print;

import java.util.Scanner;

public class ToUpperCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요> ");
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		StringBuilder[] sbArr = new StringBuilder[strArr.length];
		for(int i=0;i<sbArr.length;i++) {
			sbArr[i]=new StringBuilder(strArr[i]);
		}
		for(int i=0;i<sbArr.length;i++) {
			char f = sbArr[i].charAt(0);
			f-=32;
			sbArr[i].setCharAt(0, f);
			System.out.print(sbArr[i]+" ");
		}
		sc.close();
	}

}
