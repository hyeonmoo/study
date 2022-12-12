package exercise0926;

public class Ex11_toString {
	public static void main(String[] args) {
		Member mb=new Member("홍길동");
		System.out.println(mb);
		//println()은 인수로 객체가 올 경우 객체의 toString()메소드를 호출
	}
}