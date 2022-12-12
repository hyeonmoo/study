package exercise0923;

public class Triangle02 {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) System.out.printf("%2s"," ");
			for(int k=6-i;k<=5;k++) System.out.printf("%2d", k);
			System.out.println();
		}
	}
}
