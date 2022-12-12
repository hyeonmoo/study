package lawofjava.ch06;

public class Ex06_67 {
	static double getDistance(int x,int y,int x1, int y1) {
		int dx=x1-x;
		int dy=y1-y;
		return Math.sqrt(Math.pow(dx,2)+Math.pow(dy, 2));
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
		System.out.println();
		
		MyPoint p = new MyPoint(1,1);
		System.out.println(p.getDistance(2, 2));
	}
}

class MyPoint{
	int x,y;

	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(int x, int y) {
		int dx=x-this.x;
		int dy=y-this.y;
		return Math.sqrt(Math.pow(dx,2)+Math.pow(dy, 2));
	}
}