package exercise.print;

import java.util.Scanner;

public class ReverseStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("청개구리");
		boolean run = true;
		while(run) {
			System.out.print("I'm gonna Sbaba>");
			String text = sc.nextLine();
			char[] reverseText = new char[text.length()];
			for(int i=reverseText.length-1; i>=0; i--) {
				reverseText[i] = text.charAt(reverseText.length-1-i);
			}
			for(char reversedText : reverseText) {
				System.out.print(reversedText);
			}
			System.out.println();
			System.out.println();
		}
		
		sc.close();

	}

}
