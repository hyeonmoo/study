package examples.chapter14;

public class Example03 {

	public static void main(String[] args) {
		MFI03 fi;
		
		fi = (x, y) -> sum(x,y);
		System.out.println(fi.method(2, 5));

	}
	
	public static int sum(int x, int y) {
		return x+y;
	}
}

@FunctionalInterface
interface MFI03{
	public int method(int x, int y);
}