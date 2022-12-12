package exercise.print;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		System.out.println("완전수 판별기");
		while(run) {
			System.out.print("숫자 입력: ");
			int num = sc.nextInt();
			int count = 0;
			for(int i=1;i<num;i++) {
				if(num%i==0) {
					count += i;
				}
			}
			if(count==num) {
				System.out.println("완전수입니다.");
			} else {
				System.out.println("완전수가 아닙니다.");
			}
		}
		sc.close();
	}
}

