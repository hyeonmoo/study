package exercise.print;

class RandomGraph{
	int rand;
	String[][] array = new String[20][10];
	
	int randInt() {
		this.rand = (int)(Math.random()*21);
		return rand;
	}
	
	void graph(int rand,int j) {
		for(int i=0;i<array.length-rand;i++) {
			array[i][j] = " ";
		}
		for(int i=array.length-rand;i<array.length;i++) {
			array[i][j] = "*";
		}
	}
}

public class Graph {

	public static void main(String[] args) {
		RandomGraph rg = new RandomGraph();
		int[] arrayRandInt = new int[10];
		for(int i=0; i<arrayRandInt.length;i++) {
			arrayRandInt[i] = rg.randInt();
		}
		for(int j=0; j<arrayRandInt.length;j++) {
			rg.graph(arrayRandInt[j], j);
		}
		for(String[] i : rg.array) {
			for(String j : i) {
				System.out.printf("%4s", j);
			}
			System.out.println();
		}
		for(int i : arrayRandInt) {
			System.out.printf("%4d", i);
		}
	}

}
