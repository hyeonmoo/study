package exercise0923;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_Ch4 {

	public static void main(String[] args) {
		System.out.println("-------------Ch4_3-------------");
		int sum=0;
		for(int i=1;i<=100;i++) if(i%3==0) sum+=i;
		System.out.println("1~100까지 3의 배수의 총합: "+sum);
		
		System.out.println("-------------Ch4_4-------------");
		int diceSum=0;
		while(diceSum!=5) {
			diceSum=0;
			int[] dices = {(int)(Math.random()*6)+1,(int)(Math.random()*6)+1};
			diceSum=dices[0]+dices[1];
			System.out.println(Arrays.toString(dices));
		}
		
		System.out.println("-------------Ch4_5-------------");
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x+5*y==60) System.out.printf("(%d,%d)\n",x,y);
			}
		}
		
		System.out.println("-------------Ch4_6-------------");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) System.out.print("*");
			System.out.println();
		}
		
		System.out.println("-------------Ch4_7-------------");
		Scanner sc= new Scanner(System.in);
		boolean run=true;
		int money=0;
		while(run) {
			System.out.println("------------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택>");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.print("예금액>");
				int deposit=sc.nextInt();
				money+=deposit;
				break;
			case 2:
				System.out.print("출금액>");
				int withdraw=sc.nextInt();
				if(money<withdraw) System.out.println("잔고가 모자랍니다.");
				else money-=withdraw;
				break;
			case 3:
				System.out.println("잔고>"+money);
				break;
			case 4:
				System.out.println("프로그램 종료");
				run=false;
				break;
			}
		}
		sc.close();
		
	}

}
