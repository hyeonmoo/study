package exercise0923;

import java.util.Scanner;

public class Ex_Ch5 {

	public static void main(String[] args) {
		System.out.println("--------------------Ch5_7---------------------");
		int[] array7 = {1,5,3,8,2};
		int maxNum7=0;
		for(int num:array7) if(maxNum7<num) maxNum7=num;
		System.out.println("배열의 최대 수: "+maxNum7);
		
		System.out.println("--------------------Ch5_8---------------------");
		int[][] array8= {{95,86},{83,92,96},{78,83,93,87,88}};
		int sumArr8=0;
		int lengthArr8=0;
		for(int[] arr:array8) {
			lengthArr8+=arr.length;
			for(int num:arr) sumArr8+=num;
		}
		System.out.println("배열 전체 항목의 합과 평균");
		System.out.printf("전체 합: %d, 전체 평균: %.2f\n", sumArr8,(double)sumArr8/lengthArr8);
		
		System.out.println("--------------------Ch5_9---------------------");
		Scanner sc=new Scanner(System.in);
		boolean run9=true;
		int[] scores=null;
		int students=0;
		while(run9) {
			System.out.println("----------------------------------------------");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			try {
				System.out.print("선택> ");
				int select=sc.nextInt();
				switch(select) {
				case 1:
					System.out.print("학생수> ");
					students=sc.nextInt();
					scores=new int[students];
					break;
				case 2:
					for(int s=0;s<students;s++) {
						System.out.printf("학생%d> ",s+1);
						scores[s]=sc.nextInt();
					}
					break;
				case 3:
					for(int s=0;s<students;s++) System.out.printf("학생%d: %d\n",s+1,scores[s]);
					break;
				case 4:
					int maxScore=0;
					int totalScore=0;
					for(int score:scores) {
						if(maxScore<score) maxScore=score;
						totalScore+=score;
					}
					System.out.println("최고 점수: "+maxScore);
					System.out.println("평균 점수: "+totalScore/scores.length);
					break;
				case 5:
					System.out.println("프로그램 종료");
					run9=false;
					break;
				}
			} catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
		sc.close();
	}
}
