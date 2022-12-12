package lawofjava.ch06;

public class Ex06_22 {
	private static boolean isNumber(String str) {
		try {
			int res=Integer.parseInt(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String str="123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str="1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
	}

}
