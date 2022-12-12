package exercise0926;

import java.util.HashMap;

public class Ex11_hashCode {
	public static void main(String[] args) {
		HashMap<Member,String> hm=new HashMap<>();
		hm.put(new Member("홍길동"), "반장"); //해시맵의 Key값으로 "홍길동" Member객체를 생성
		String value=hm.get(new Member("홍길동")); //새로운 Member객체를 생성해 Key값과 동일한 객체는 아니지만
												 //hashCode()와 equals()가 같은 값을 리턴하므로 논리적으로 동등한 객체로 취급
		System.out.println(value);				 //"반장" 문자열이 정상적으로 출력됨
	}
}
