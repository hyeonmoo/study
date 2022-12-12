package exercise.print;

import java.util.Scanner;

class TikTacToeC{
	String[][] TTTArr;
	int[] inputIntArr = new int[2];
	
	public TikTacToeC(String[][] TTTArr) {
		this.TTTArr = TTTArr;
	}
	
	public int[] inputValue(String[] inputArr) {
		for(int i=0; i<inputIntArr.length; i++) {
			inputIntArr[i]=Integer.parseInt(inputArr[i]);
		}
		return inputIntArr;
	}
	
	public void printMap() {
		for(String[] tttArri : TTTArr) {
			for(String tttArrj : tttArri) {
				System.out.printf("%2s",tttArrj);
			}
			System.out.println();
		}
	}
	
	public boolean p1Pick(int i, int j) {
		if(this.TTTArr[i-1][j-1]==".") {
			this.TTTArr[i-1][j-1] = "O";
			return true;
		}
		else return false;
	}
	public boolean p2Pick(int i, int j) {
		if(this.TTTArr[i-1][j-1]==".") {
			this.TTTArr[i-1][j-1] = "X";
			return true;
		}
		else return false;
	}
	
	public boolean bingo() {
		for(int i=0; i<TTTArr.length; i++) {
				if(!TTTArr[i][0].equals(".") && TTTArr[i][0].equals(TTTArr[i][1]) && TTTArr[i][0].equals(TTTArr[i][2])) return true;
				if(!TTTArr[0][i].equals(".") && TTTArr[0][i].equals(TTTArr[1][i]) && TTTArr[0][i].equals(TTTArr[2][i])) return true;
				if(!TTTArr[0][0].equals(".") && TTTArr[0][0].equals(TTTArr[1][1]) && TTTArr[0][0].equals(TTTArr[2][2])) return true;
				if(!TTTArr[0][2].equals(".") && TTTArr[0][2].equals(TTTArr[1][1]) && TTTArr[1][1].equals(TTTArr[2][0])) return true;
		}
		return false;
	}
	
}

public class TikTacToe {

	public static void main(String[] args) {
		String[][] TTTArr = new String[3][3];
		for(int i=0; i<TTTArr.length; i++) {
			for(int j=0; j<TTTArr[i].length;j++) {
				TTTArr[i][j] = ".";
			}
		}
		
		Scanner sc = new Scanner(System.in);
		TikTacToeC ttt = new TikTacToeC(TTTArr);
		System.out.println("---Tic Tac Toe---");
		System.out.println("x(1~3),y(1~3)좌표입력 예) 1 3 = 1행 3열");
		
		boolean run = true;
		boolean player = true;
		String input = "";
		boolean isAlready = true;
		boolean isBingo = false;
		int cnt =0;
		
		ttt.printMap();
		while(run) {
			try {
				if(player) {
					System.out.print("Player1 입력> ");
					input = sc.nextLine();
					String[] inputArr = input.split(" ");
					int[] inputIntArr = ttt.inputValue(inputArr);
					isAlready = ttt.p1Pick(inputIntArr[0], inputIntArr[1]);
					if(!isAlready) {
						System.out.println("이미 입력된 자리입니다.");
						continue;
					}
					ttt.printMap();
					isBingo = ttt.bingo();
					if(isBingo) {
						System.out.println("Player1 승리!");
						break;
					} else {
						player = false;
						cnt++;
					}
				} else {
					System.out.print("Player2 입력> ");
					input = sc.nextLine();
					String[] inputArr = input.split(" ");
					int[] inputIntArr = ttt.inputValue(inputArr);
					isAlready = ttt.p2Pick(inputIntArr[0], inputIntArr[1]);
					if(!isAlready) {
						System.out.println("이미 입력된 자리입니다.");
						continue;
					}
					ttt.printMap();
					isBingo = ttt.bingo();
					if(isBingo) {
						System.out.println("Player2 승리!");
						break;
					} else {
						player = true;
						cnt++;
					}
				}
				if(cnt==9 && !isBingo) {
					System.out.println("무승부");
					break;
				}
			} catch(Exception e) {
				System.out.println("옳지 않은 입력입니다.");
				continue;
			}
		}
		sc.close();
	}

}
