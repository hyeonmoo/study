package exercise0927;

public class Ex11_StringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Java ");
		sb.append("Program study");
		
		System.out.println(sb);
		System.out.println(sb.toString());
		
		sb.insert(4, "2");
		System.out.println(sb);
		
		sb.setCharAt(4,'6');
		System.out.println(sb);
		
		sb.replace(6, 13, "book");
		System.out.println(sb);
		
		sb.delete(4, 5);
		System.out.println(sb);
		
		int len=sb.length();
		System.out.println("문자열 길이: "+len);
		String res=sb.toString();
		System.out.println(res);
	}

}
