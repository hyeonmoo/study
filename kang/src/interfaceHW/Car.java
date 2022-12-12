package interfaceHW;

public class Car implements MyInterface{
	private int speed;
	
	@Override
	public void setSpeed(int speed) {
		if(speed>MAX_SPEED) {
			System.out.println("차량의 최대속도 초과");
			return;
		}
		this.speed = speed;
		System.out.println(this.speed+"km/h");
	}
}
