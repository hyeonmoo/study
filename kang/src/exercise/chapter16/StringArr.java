package exercise.chapter16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StringArr {

	public static void main(String[] args) {
		String[] strArr = {"aaa","cc","b","dddd"};
		Stream<String> strStream = Arrays.stream(strArr);
		
		int totalLength = strStream.mapToInt(String::length)
				.sum();
		System.out.println("문자열의 길이의 총합: "+totalLength);
		
		strStream = Arrays.stream(strArr);
		int maxLength = strStream.mapToInt(String::length)
				.max()
				.getAsInt();
		System.out.println("가장 긴 문자열의 길이: "+maxLength);
		
		strStream = Arrays.stream(strArr);
		strStream.sorted()
		.forEach(s->System.out.print(s+" "));
		
		System.out.println();
		
		strStream = Arrays.stream(strArr);
		strStream.sorted(Comparator.reverseOrder())
		.forEach(s->System.out.print(s+" "));

	}

}