package lawofjava.ch06;

public class Ex06_24 {
	private static int abs(int value) {
		if(value<0) return value-(2*value);
		else return value;
	}
	public static void main(String[] args) {
		int value=5;
		System.out.println(value+"의 절대값: "+abs(value));
		value=-10;
		System.out.println(value+"의 절대값: "+abs(value));
	}

}
