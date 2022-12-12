package exercise.print;

import java.util.Scanner;

class Samyukku{
	int inputNum;
	int increasingNum;
	int[] numArray;
	int jjack;
	int sacNum;
	
	void numberLength(int increasingNum) {
		this.increasingNum = increasingNum;
		for(int i=0;i<100;i++) {
			if(this.increasingNum/(int)(Math.pow(10, i))==0) {
				this.numArray = new int[i];
				return;
			}
		}
	}
	
	void keepNumArray(int increasingNum) {
		numberLength(increasingNum);
		this.sacNum = increasingNum;
		for(int i=0;i<this.numArray.length;i++) {
			this.numArray[i] = sacNum%10;
			sacNum/=10;
		}
	}
	
	int samyuku(int inputNum) {
		this.inputNum = inputNum;
		for(int i=1; i<=this.inputNum;i++) {
			keepNumArray(i);
			for(int j=0; j<this.numArray.length; j++) {
				if(this.numArray[j]!=0 && this.numArray[j]%3==0) this.jjack++;
			}
		}
		return jjack;
	}
}

public class Samyuku {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("------------");
			System.out.println("잼밋는 369게임!");
			System.out.print("숫자 입력>");
			int inputNum = sc.nextInt();
			Samyukku syk = new Samyukku();
			int jjack = syk.samyuku(inputNum);
			System.out.printf("%d까지는 박수를 %d번 쳐야합니다.\n", inputNum,jjack);
		}
		sc.close();
	}

}
