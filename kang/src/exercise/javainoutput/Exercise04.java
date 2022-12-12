package exercise.javainoutput;

import java.io.FileReader;

public class Exercise04 {

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("writer01.txt");
		int i;
		while((i = fr.read())!=-1) {
			System.out.print((char)i);
		}
		
		fr.close();

	}

}
