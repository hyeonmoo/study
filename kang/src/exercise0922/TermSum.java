package exercise0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TermSum {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] bin = bf.readLine().split(" ");
		String[] numsArrStr = bf.readLine().split(" ");
		ArrayList<Integer> numsArr=new ArrayList<>(Integer.parseInt(bin[0]));
		for(String num:numsArrStr) {
			numsArr.add(Integer.parseInt(num));
		}
		ArrayList<Integer> sumArr=new ArrayList<>();
		sumArr.add(numsArr.get(0));
		for(int i=1;i<numsArr.size();i++) {
			sumArr.add(sumArr.get(i-1)+numsArr.get(i));
		}
		ArrayList<Integer> results=new ArrayList<>(Integer.parseInt(bin[1]));
		for(int i=0;i<Integer.parseInt(bin[1]);i++) {
			String[] binary=bf.readLine().split(" ");
			int start = Integer.parseInt(binary[0])-1;
			int end = Integer.parseInt(binary[1])-1;
			int termSum=0;
			if(start==0) {
				termSum=sumArr.get(end);
			} else {
				termSum = sumArr.get(end)-sumArr.get(start-1);
			}
			results.add(termSum);
		}
		for(int res:results) {
			System.out.println(res);
		}
	}

}
