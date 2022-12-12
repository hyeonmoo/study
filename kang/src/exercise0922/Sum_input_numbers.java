package exercise0922;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum_input_numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run=true;
		while(run) {
			int numLength=sc.nextInt();
			sc.nextLine();
			String numStr=sc.nextLine();
			ArrayList<Integer> numArr=new ArrayList<>();
			for(int i=0;i<numLength;i++) {
				numArr.add(Integer.parseInt(String.valueOf(numStr.charAt(i))));
			}
			int sum=0;
			for(int num:numArr) {
				sum+=num;
			}
			System.out.println(sum);
		}
		sc.close();
	}

}