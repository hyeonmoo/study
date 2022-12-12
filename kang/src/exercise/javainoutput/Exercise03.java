package exercise.javainoutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) throws Exception{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("writer00.txt"));
		Scanner sc = new Scanner(System.in);
		try(isr){
			int i;
			while((i = isr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
