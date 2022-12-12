package examples.chapter14;

public class Example02 {

	public static void main(String[] args) {
		MFI02 fi;
		fi = x-> System.out.println(x*5); //람다식으로 인터페이스 구현
		fi.method(3); // 람다식 실행

	}

}

@FunctionalInterface
interface MFI02{
	public void method(int x);
}