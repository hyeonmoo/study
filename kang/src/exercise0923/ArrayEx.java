package exercise0923;

public class ArrayEx {

	public static void main(String[] args) {
		int[][] a = new int[2][2];
		a=new int[][] {{90,80},{70,60}};
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length; j++) System.out.printf("%3d", a[i][j]);
			System.out.println();
		}
		System.out.println("--------------");
		int[][]b=new int [2][];
		b[0]=new int[2];
		b[1]=new int[2];
		b=new int[][]{{90,80},{70,60}};
		for(int[]i:b) {
			for(int j:i) System.out.printf("%3d", j);
			System.out.println();
		}
		System.out.println("--------------");
		int[][]c= new int[2][];
		c[0]=new int[] {90,80};
		c[1]=new int[] {70,60};
		for(int[]i:c) {
			for(int j:i) System.out.printf("%3d", j);
			System.out.println();
		}

	}

}
