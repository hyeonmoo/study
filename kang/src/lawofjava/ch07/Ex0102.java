package lawofjava.ch07;

public class Ex0102 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		for(SutdaCard card:deck.cards) System.out.print(card+",");
		System.out.println();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		for(SutdaCard card:deck.cards) System.out.print(card+",");
		System.out.println();
		System.out.println(deck.pick(0));
	}
}

class SutdaCard{
	int num;
	boolean isKwang;
	public SutdaCard() {
		this(1,true);
	}
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	@Override public String toString() {return num+(isKwang?"K":"");}
}

class SutdaDeck{
	final int CARD_NUM=20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for(int i=0;i<CARD_NUM;i++) {
			boolean kwang=false;
			if(i==0||i==2||i==7) kwang=true;
			if(i>9) cards[i]=new SutdaCard(i-9,kwang);
			else cards[i]=new SutdaCard(i+1,kwang);
		}
	}
	
	public void shuffle() {
		for(int i=0;i<this.CARD_NUM;i++) {
			int j=(int)(Math.random()*this.CARD_NUM);
			SutdaCard tmp=cards[i];
			cards[i]=cards[j];
			cards[j]=tmp;
		}
	}
	public SutdaCard pick(int index) {return cards[index];}
	public SutdaCard pick() {return cards[(int)(Math.random()*CARD_NUM)];}
}