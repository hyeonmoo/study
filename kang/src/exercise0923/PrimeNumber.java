package exercise0923;

public class PrimeNumber {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=100;i++) {
			boolean prime=true;
			for(int a=2;a<i;a++) {
				if(i%a==0) {
					prime=false;
					break;
				}
			}
			if(prime) sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
}
