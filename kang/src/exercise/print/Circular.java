package exercise.print;

import java.util.Scanner;

public class Circular {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.print("입력> ");
			String sent = sc.nextLine();
			String[] wordArr = sent.split(" ");
			String sentense = "";
			for(String w : wordArr) {
				sentense += w;
			}
			System.out.println(sentense);
			char[] charArr = new char[sentense.length()];
			for(int i=0; i<charArr.length; i++) {
				charArr[i] = sentense.charAt(i);
			}
			boolean tf = true;
			for(int i=0; i<charArr.length/2; i++) {
				if(charArr[i]!=charArr[charArr.length-1-i]) tf=false;
			}
			if(tf) System.out.println("회문입니다.");
			else System.out.println("회문이 아닙니다.");			
		}
		
		sc.close();

	}

}
