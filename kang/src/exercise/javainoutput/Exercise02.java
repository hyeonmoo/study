package exercise.javainoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(FileWriter fw = new FileWriter("writer01.txt")){
			System.out.print("메모장에 넣고 싶은 문장을 입력하세요.");
			String str = sc.nextLine();
			fw.write(str);
			System.out.println("writer01.txt 파일을 확인하세요");
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}

}
