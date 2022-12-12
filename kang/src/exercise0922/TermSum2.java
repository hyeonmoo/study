package exercise0922;

import java.util.Scanner;

public class TermSum2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int trow = sc.nextInt();
		int test = sc.nextInt();
		
		int[][]table = new int[trow][trow];
		for(int r=0;r<table.length;r++) {
			for(int c=0;c<trow;c++) {
				if(c==0) table[r][c]=sc.nextInt();
				else table[r][c]=table[r][c-1]+sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<test;i++) {
			int[] start= {sc.nextInt()-1,sc.nextInt()-1};
			int[] end= {sc.nextInt()-1,sc.nextInt()-1};
			int totSum=0;
			int rowSum=0;
			for(int r=start[0];r<=end[0];r++) {
				if(start[1]==0) rowSum=table[r][end[1]];
				else rowSum=table[r][end[1]]-table[r][start[1]-1];
				totSum+=rowSum;
			}
			sb.append(totSum+"\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

}
