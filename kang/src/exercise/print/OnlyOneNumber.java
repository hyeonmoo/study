package exercise.print;
import java.util.Scanner;

public class OnlyOneNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean tf = true;
		while(run) {
			System.out.print("숫자 입력: ");
			String num = sc.nextLine();
			int[] arr = new int[num.length()];
			if(arr.length==1) {
				System.out.println("한 자리 수입니다.");
				continue;
			}
			for(int i=0;i<arr.length;i++) {
				arr[i]=num.charAt(i);
			}
			for(int n : arr) {
				if(n!=arr[0]) tf=false;
				else tf=true;
			}
			if(tf) System.out.println("True");
			else System.out.println("False");
		}
		sc.close();

	}

}
