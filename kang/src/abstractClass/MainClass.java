package abstractClass;

public class MainClass {
	public static void main(String[] args) {
		Dog dog = new Dog(); //Dog클래스 인스턴스객체 생성
		dog.sound();
		dog.breath(); //Animal에서 정의된 breath메소드 호출
	}
}
