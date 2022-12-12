package exercise0926;

public class Ex08_05_TV implements Remocon{
	@Override
	public void powerOn() {System.out.println("TV를 켰습니다.");}
	
	public static void main(String[] args) {
		Remocon r = new Ex08_05_TV();
		r.powerOn();
	}

}

interface Remocon{public void powerOn();}