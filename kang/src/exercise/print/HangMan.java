package exercise.print;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangMan {

	private static <T> void printArr(T[] array) {
		for(T t : array) {
			System.out.print(t);
		}
	}
	private static char randChar() {
		int randInt = (int)(Math.random()*26)+97;
		char randChar = (char)randInt;
		return randChar;
	}
	
	public static void main(String[] args) throws Exception{
		Thread.sleep(2000);
		System.out.println("사람의 신체는 총 11부분으로 나눌 수 있습니다");
		Thread.sleep(2000);
		System.out.println("머리카락, 머리, 눈, 코, 입, 귀, 몸통, 팔, 다리, 손, 발");
		Thread.sleep(2000);
		System.out.println("HangMan Start");
		Thread.sleep(1000);
		String[] human = {"머리카락","머리","눈","코","입","귀","몸통","팔","다리","손","발"};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=============");
//		System.out.print("제시어 입력>> ");
//		String word = sc.nextLine();
		
//		System.out.println(word.length()+"자리 단어가 제시되엇슴미다.");
//		
//		List<String> list = new LinkedList<String>();
//		for(int i=0; i<word.length(); i++) {
//			list.add(String.valueOf(word.toLowerCase().charAt(i)));
//		}
		int randLength = (int)(Math.random()*3)+4;
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<randLength;i++) {
			list.add(String.valueOf(randChar()));
		}
		System.out.println(randLength+"자리 단어가 제시되었습니다.");
		
//		list.stream().forEach(System.out::print);		//주석제거 시 제시어 출력
//		System.out.println();
		
		String[] rightAnswer = new String[list.size()];
		for(int i=0;i<rightAnswer.length;i++) {
			rightAnswer[i]="_";
		}
		
		int hanger = 0;
		while(hanger<11) {
			System.out.print("철자 입력>> ");
			String spelling = sc.nextLine().toLowerCase();
			if(spelling.length()>1) {
				System.out.println("철자 하나만 입력하십시오!");
				continue;
			}
			boolean noneMatch = list.stream().noneMatch(a->a.equals(spelling));
			if(noneMatch) {
				System.out.println(human[hanger++]+" 생성");
				continue;
			}
			
			for(int i=0;i<list.size();i++) {
				if(spelling.equals(list.get(i))) {
					rightAnswer[i]=spelling;
					list.set(i, "0");
					printArr(rightAnswer);
					System.out.println();
				}
			}
			
			boolean match = list.stream()
					.allMatch(a->a=="0");
			if(match) {
				System.out.println("승리!");
				break;
			}
			
			
		}
		if(hanger==11) System.out.println("failed...");
		sc.close();
	}

}
