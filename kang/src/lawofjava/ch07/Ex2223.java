package lawofjava.ch07;

public class Ex2223 {
	private static double sumArea(Shape[] arr) {
		double totalArea=0;
		for(Shape shape:arr) totalArea+=shape.calcArea();
		return totalArea;
	}
	public static void main(String[] args) {
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("면적의 합: "+sumArea(arr));
	}
}

abstract class Shape{
	Point p;
	Shape(){this(new Point(0,0));}
	Shape(Point p){this.p=p;}
	abstract double calcArea();
	Point getposition() {return this.p;}
	void setPosition(Point p) {this.p=p;}
}

class Point{
	int x,y;
	Point(){this(0,0);}
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString() {return "("+x+","+y+")";}
}
class Circle extends Shape {
	double r;
	Circle(double r){this.r=r;}
	double calcArea() {
		return Math.PI*Math.pow(r, 2);
	}
}
class Rectangle extends Shape{
	Rectangle(int x,int y){super(new Point(x,y));}
	double calcArea() {return this.p.x*this.p.y;}
	boolean isSquare() {
		return this.p.x==this.p.y;
	}
}