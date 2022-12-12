package exercise0922;

import java.util.ArrayList;
import java.util.Scanner;

public class Fake_avg {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean run=true;
		while(run) {
			int classNum=sc.nextInt();
			sc.nextLine();
			String[] scores_str=sc.nextLine().split(" ");
			ArrayList<Integer> scores=new ArrayList<>();
			for(String score:scores_str) {
				scores.add(Integer.parseInt(score));
			}
			int maxScore=0;
			for(int score:scores) {
				if(maxScore<score) maxScore=score;
			}
			double totFakeScore=0;
			for(int score:scores) {
				totFakeScore+=score;
			}
			System.out.println(totFakeScore*100/(classNum*maxScore));
		}
		sc.close();
	}

}
