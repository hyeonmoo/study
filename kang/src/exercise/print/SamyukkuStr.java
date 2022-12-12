package exercise.print;

import java.util.Scanner;

public class SamyukkuStr {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("잼밋는 369놀이!");
		boolean run = true;
		while(run) {
			System.out.print("숫자 입력: ");
			String num = sc.nextLine();
			String[] numArr = numArr(num);
			int count = samyukku(numArr);
			System.out.println(count);
		}
		sc.close();

	}

	
	private static String[] numArr(String num) {
		String[] numArr = new String[Integer.parseInt(num)];
		for(int i=0;i<numArr.length;i++) {
			numArr[i] = String.valueOf(i+1);
		}
		return numArr;
	}
	private static int samyukku(String[] arr) {
		cnt = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length();j++) {
				if(arr[i].charAt(j)=='3' || arr[i].charAt(j)=='6' || arr[i].charAt(j)=='9') cnt++;
			}
		}
		return cnt;
	}
}
