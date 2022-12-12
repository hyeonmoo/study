package exercise0926;

public class Ex11_eqauls {
	public static void main(String[] args) {
		Member obj1=new Member("blue");
		Member obj2=new Member("blue");
		
		if(obj1==obj2) System.out.println("동등 객체입니다.");
		else System.out.println("동등 객체가 아닙니다.");
		if(obj1.equals(obj2)) System.out.println("논리적 동등 객체입니다.");
		else System.out.println("논리적으로 다른 객체입니다.");
	}
}