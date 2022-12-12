package lawofjava.ch07;

public class Ex27 {

	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.method1();
	}

}
class Outer{
	int value=10;
	class Inner{
		int value=20;
		void method1() {
			int value=30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer.this.value);
		}
	}
}