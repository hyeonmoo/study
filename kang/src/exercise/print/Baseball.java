package exercise.print;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] numArr = randArr(3);		
		System.out.println(Arrays.toString(numArr));
		
		int run = 3;		
		chance : while(run>0) {
			int strike = 0;
			int ball = 0;
			
			System.out.printf("남은 기회: %d\n", run);
			System.out.print("Playball> ");
			String pitch = sc.nextLine();
			if(pitch.length()!=numArr.length) {
				System.out.println("다시 투구하세요.");
				continue;
			}
			
			try {
				int[] pitchArr = stringToInt(pitch);
				boolean isRepeated = isRepeatedNum(pitchArr);
				if(!isRepeated) {
					System.out.println("서로 다른 숫자를 입력하세요.");
					continue chance;
				}
				
				strike = judgmentSB(numArr,pitchArr,strike,ball);
				
				run--;
				if(strike==numArr.length) {
					System.out.println("승리!");
					break chance;
				} else if(run==0) System.out.println("패배");
				
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
				continue;
			}
		}
		
		sc.close();

	}
	
	//랜덤한 수를 받아 int타입 배열로 저장
	private static int[] randArr(int numLength) {
		int[] numArr = new int[numLength];
		boolean repeated=true;
		while(repeated) {
			boolean tf=true;
			for(int i=0;i<numArr.length;i++) {
				numArr[i]=(int)(Math.random()*9)+1;
			}
			for(int i=0;i<numArr.length;i++) {
				for(int j=0;j<numArr.length;j++) {
					if(i!=j && numArr[i]==numArr[j]) tf=false;
				}
			}
			if(tf) repeated=false;
		}
		return numArr;
	}
	
	//입력한 String타입 숫자를 int타입으로 변환 후 배열에 저장
	private static int[] stringToInt(String pitch) {
		int[] pitchArr = new int[pitch.length()];
		for(int i=0;i<pitchArr.length;i++) {
			String p = pitch.charAt(i)+"";
			pitchArr[i] = Integer.parseInt(p);
		}
		
		return pitchArr;
	}
	
	//입력받은 숫자끼리 중복이 없는지 검사
	private static boolean isRepeatedNum(int[] pitchArr) {
		for(int i=0; i<pitchArr.length;i++) {
			for(int j=0;j<pitchArr.length;j++) {
				if(i!=j && pitchArr[i]==pitchArr[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int judgmentSB(int[] numArr, int[] pitchArr, int strike, int ball) {
		for(int i=0;i<pitchArr.length;i++) {
			for(int j=0;j<numArr.length;j++) {
				if(pitchArr[i]==numArr[j]) {
					if(i==j) strike++;
					else ball++;
				}
			}
		}
		if(strike==0 && ball==0) System.out.println("OUT");
		else System.out.printf("%d STRIKE %d BALL\n", strike,ball);
		
		return strike;
	}
	
}


