package abstractClass;

public class Dog extends Animal{
	public Dog() { //생성자 선언
		super("표유류");
	}
	@Override
	public void sound() { //추상 메소드 재정의
		System.out.println("멍멍");
	}
}
