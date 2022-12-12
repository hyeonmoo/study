package exercise.print;

import java.util.Scanner;

public class CharatEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		char[] charArr;
		
		System.out.println("----------------------------");
		System.out.println("----------회문 판독기----------");
		System.out.println("종료를 원하시면 quit을 입력해주세요.");
		while(run) {
			System.out.print("문자열을 입력하시오> ");
			String s = sc.nextLine();
			if(s.equals("quit")) {
				System.out.println("프로그램 종료");
				break;
			}
			charArr = new char[s.length()];
			boolean tf = true;
			for(int i=0; i<s.length();i++) {
				charArr[i] = s.charAt(i);
			}
			for(int i=0;i<charArr.length/2;i++) {
				if(charArr[i]!=charArr[charArr.length-(i+1)]) {
					tf = false;
				} else continue;
			}
			if(tf) {
				System.out.println("회문입니다.");
			} else System.out.println("회문이 아닙니다.");
			System.out.println("----------------------------");
		}
		sc.close();

	}

}
