package exercise.print;

import java.util.Scanner;

class ReversingInt{
	int num;
	int[] numArray;
	int cnt;
	int reversedNumber;
	
	ReversingInt(int num){
		this.num = num;
	}
	
	int numberLength() {
		for(int i=0;i<100;i++) {
			if(this.num/(int)(Math.pow(10, i))==0) {
				this.numArray = new int[i];
				return i;
			}
		}
		return 0;
	}
	
	int[] keepNumArray() {
		numberLength();
		for(int i=0;i<this.numArray.length;i++) {
			this.numArray[i] = num%10;
			num/=10;
		}
		return numArray;
	}
	
	int reverseNum() {
		keepNumArray();
		for(int i=numArray.length-1;i>=0;i--) {
			reversedNumber += numArray[i]*(int)Math.pow(10, cnt);
			cnt++;
		}
		return reversedNumber;
	}
	
}

public class ReverseInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.print("숫자 입력: ");
			int num = sc.nextInt();
			int sac = num;
			ReversingInt ri = new ReversingInt(sac);
			int reversedNumber = ri.reverseNum();
			System.out.printf("%d+%d=%d\n",num,reversedNumber,num+reversedNumber);
		}
		sc.close();
		
	}

}
