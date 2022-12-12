package lawofjava.ch06;

public class Ex06_12 {

	public static void main(String[] args) {
		SutdaCard card1=new SutdaCard(3,false);
		SutdaCard card2=new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}

}

class SutdaCard{
	public int num;
	public boolean isKwang;
	public SutdaCard() {
		this.num=1;
		this.isKwang=true;
	}
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public String info() {
		if(isKwang) return String.valueOf(num)+"K";
		else return String.valueOf(num);
	}
	
}