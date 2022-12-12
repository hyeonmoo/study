package exercise0923;

public class Triangle03 {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) System.out.printf("%2s", " ");
			for(int k=1;k<=i;k++) System.out.printf("%2d", k);
			for(int h=1;h<i;h++) System.out.printf("%2d", h);
			System.out.println();
		}
	}
}
