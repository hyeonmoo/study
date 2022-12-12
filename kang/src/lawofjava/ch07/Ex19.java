package lawofjava.ch07;

public class Ex19 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}

}

class Buyer{
	private int money=1000;
	private Product[] cart=new Product[3];
	private int i=0;
	
	public void buy(Product p) {
		if(this.money<p.price) {
			System.out.println("잔액이 부족하여 "+p+"를 살 수 없습니다.");
			return;
		}
		this.add(p);
		this.money-=p.price;
		System.out.println(p+" 구매");
	}
	public void add(Product p) {
		if(i>=cart.length) {
			Product[] tmp=cart;
			cart=new Product[2*cart.length];
			i=0;
			for(Product product:tmp) add(product);
		}
		this.cart[i++]=p;
	}
	
	public void summary() {
		System.out.print("구입한 물건: ");
		int totalMoney=0;
		for(Product p:cart) {
			totalMoney+=p.price;
			System.out.print(p+", ");
		}
		System.out.println("\n총 구매금액: "+totalMoney);
		System.out.println("남은 돈: "+(this.money));
	}
}
class Product{
	public int price;
	
	public Product(int price) {this.price=price;}
}
class Tv extends Product{
	Tv(){super(100);}
	public String toString() {return "TV";}
}
class Computer extends Product{
	Computer(){super(200);}
	public String toString() {return "COMPUTER";}
}
class Audio extends Product{
	Audio(){super(50);}
	public String toString() {return "AUDIO";}
}