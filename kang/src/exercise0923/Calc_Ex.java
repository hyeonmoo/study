package exercise0923;

public class Calc_Ex {

	public static void main(String[] args) {
		Calc myCal=new Calc();
		myCal.setX(1);
		myCal.setY(2);
		
		myCal.PowerOn();
		System.out.println(myCal.plus());
		System.out.println(myCal.minus());
		System.out.println(myCal.div());
		System.out.println(myCal.circle(3));
		
		myCal.PowerOff();

	}

}
