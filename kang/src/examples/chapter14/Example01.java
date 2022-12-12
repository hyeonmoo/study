package examples.chapter14;

public class Example01 {

	public static void main(String[] args) {
		MFI01 fi;
		fi = () -> System.out.println("method call"); //람다식으로 인터페이스 구현
		fi.method(); //람다식 실행

	}

}

@FunctionalInterface
interface MFI01{
	public void method();
}
