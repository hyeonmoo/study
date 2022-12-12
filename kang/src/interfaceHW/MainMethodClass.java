package interfaceHW;

public class MainMethodClass {
	public static void main(String[] args) {
		A a = new A();
		a.method(123); //메소드가 실행-종료되면서 B객체 생성-사용-소멸
	}
}

class A{
	int method(int arg) { //매개변수가 B로컬클래스에서 사용되므로 final특성을 가짐
		int localVar = 1; //로컬변수가 B로컬클래스에서 사용되므로 final특성을 가짐
		class B{
			int result = arg+localVar;
		}
		B b = new B();
		return b.result;
	}
}
