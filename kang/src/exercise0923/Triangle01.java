package exercise0923;

public class Triangle01 {

	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=5-i;j>0;j--) System.out.printf("%2s", " ");
			for(int k=i;k>=1;k--) System.out.printf("%2s", k);
			System.out.println();
		}
	}

}
