package abstractClass;

public abstract class Animal {
	public String kind;
	
	public Animal(String kind) { //생성자 선언
		this.kind = kind;
	}
	
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();  //추상 메소드 선언
}
