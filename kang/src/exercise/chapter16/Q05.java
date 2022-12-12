package exercise.chapter16;

import java.util.Arrays;
import java.util.List;

public class Q05 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"This is a java book",
				"Lambda Expressions",
				"Java8 supports lambda expressions"
				);
		list.stream()
		.filter(s->s.toLowerCase().indexOf("java")!=-1)
		.forEach(System.out::println);

	}

}
