package exercise.javainoutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Exercise01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("writer00.txt"))){
			System.out.print("메모장에 넣고 싶은 문장을 입력하세요: ");
			String str = sc.nextLine();
			osw.write(str);			
			System.out.println("writer.txt 파일을 확인해보세요.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();

	}

}
