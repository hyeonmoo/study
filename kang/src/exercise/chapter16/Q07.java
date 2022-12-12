package exercise.chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q07 {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", "개발자"),
				new Member("김나리", "디자이너"),
				new Member("신용권", "개발자")
			);
		
		List<Member> developers = list.stream()
				.filter(s->s.getJob()=="개발자")
				.collect(Collectors.toList());
		
		developers.stream()
		.forEach(m->System.out.println(m.getName()));
	}
}
