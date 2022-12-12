package interfaceHW;

public interface MyInterface { //인터페이스 선언
	int MAX_SPEED = 300; //상수선언(public static final)
	
	void setSpeed(int speed); //추상메소드 선언(public abstract)
	
	default void warning(boolean warn) { //디폴트메소드 선언(public)
		if(warn) System.out.println("비상등ON");
		else System.out.println("비상등OFF");
	}
	
	static void chargeOil() { //정적메소드 선언(public)
		System.out.println("기름을 넣습니다.");
	}
}
