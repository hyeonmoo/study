package exercise0923;

public class Calc {
	int x,y;
	static double Pi=Math.PI;
	
	int plus() {return x+y;}
	int minus() {return x-y;}
	double div() {return x/(y*1.0);}
	double circle(int r) {return Math.pow(r, 2)*Pi;}
	
	void PowerOn() {System.out.println("전원이 켜졌습니다.");}
	void PowerOff() {System.out.println("전원이 꺼졌습니다.");}
	public void setX(int x) {this.x=x;}
	public void setY(int y) {this.y=y;}
}
