package exercise.print;

import java.util.Scanner;

public class ReverseStrInIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.print("입력> ");
			String str = sc.nextLine();
			String[] strArr = str.split(" ");
			for(int i=0; i<strArr.length; i++) {
				char[] charArr = new char[strArr[i].length()];
				for(int j=charArr.length-1; j>=0; j--) {
					charArr[charArr.length-1-j]=strArr[i].charAt(j);
					System.out.print(charArr[charArr.length-1-j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		sc.close();

	}

}
