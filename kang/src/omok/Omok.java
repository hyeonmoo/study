package omok;

import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		Pan pan=new Pan();
		Piece black=new Piece("●");
		Piece white=new Piece("○");
		
		Scanner sc=new Scanner(System.in);
		
		boolean run=true;
		boolean turn=true;
		int[] intPoint=new int[2];
		while(run) {
			if(turn) {
				System.out.print("흑 착점: ");
				String[] point=sc.nextLine().split(" ");
				intPoint[0]=Integer.parseInt(point[1]); // 사람의 관점에선 x축,y축 순으로 좌표를 매기지만 배열에선 세로축, 가로축 순으로 좌표가 찍히므로
				intPoint[1]=Integer.parseInt(point[0]); // 입력받은 값을 거꾸로 집어넣어 좌표기준을 일관화하는 과정
				if(!pan.insertion(intPoint[0], intPoint[1], black)) continue;
				pan.print();
				Winner win=new Winner(pan,black);
				if(win.win()) {
					System.out.println("흑 승리!!");
					run=false;
				} else turn=false;
			} else {
				System.out.print("백 착점: ");
				String[] point=sc.nextLine().split(" ");
				intPoint[0]=Integer.parseInt(point[1]); // 사람의 관점에선 x축,y축 순으로 좌표를 매기지만 배열에선 세로축, 가로축 순으로 좌표가 찍히므로
				intPoint[1]=Integer.parseInt(point[0]); // 입력받은 값을 거꾸로 집어넣어 좌표기준을 일관화하는 과정
				if(!pan.insertion(intPoint[0], intPoint[1], white)) continue;
				pan.print();
				Winner win=new Winner(pan,white);
				if(win.win()) {
					System.out.println("백 승리!!");
					run=false;
				} else turn=true;
			}
		}
		sc.close();
	}
}
