package exercise0923;

public class Ex6_Account {
	public static void main(String[] args) {
		Account19 ac = new Account19();
		ac.setBalance(10000);
		System.out.println(ac.getBalance());
		ac.setBalance(-100);
		System.out.println(ac.getBalance());
		ac.setBalance(2000000);
		System.out.println(ac.getBalance());
		ac.setBalance(300000);
		System.out.println(ac.getBalance());
	}
}

class Account19{
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance<0 || balance>1000000) return;
		else this.balance=balance;
	}
}