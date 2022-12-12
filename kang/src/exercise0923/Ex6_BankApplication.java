package exercise0923;

import java.util.Scanner;

public class Ex6_BankApplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean run=true;
		Account20[] acArr=new Account20[30];
		while(run) {
			System.out.println("----------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			int select=sc.nextInt();
			switch(select) {
			case 1:
				sc.nextLine();
				System.out.println("--------");
				System.out.println(" 계좌생성");
				System.out.println("--------");
				System.out.print("계좌번호: ");
				String account=sc.nextLine();
				System.out.print("계좌주: ");
				String name=sc.nextLine();
				System.out.print("초기입금액: ");
				int balance=sc.nextInt();
				System.out.print("결과: ");
				boolean result=true;
				for(Account20 accountInfo:acArr) {
					if(accountInfo!=null) {
						if(accountInfo.getAccount().equals(account)) {
							System.out.println("이미 생성된 계좌입니다.");
							result=false;
							break;
						}
					}
				}
				if(result) {
					for(int i=0;i<acArr.length;i++) {
						if(acArr[i]==null) {
							acArr[i]=new Account20(account,name,balance);
							System.out.println("계좌가 생성되었습니다.");
							break;
						}
					}
				} else break;
				break;
			case 2:
				sc.nextLine();
				System.out.println("--------");
				System.out.println(" 계좌목록");
				System.out.println("--------");
				for(Account20 accountInfo : acArr) {
					if(accountInfo!=null) System.out.println(accountInfo);
					else break;
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("--------");
				System.out.println(" 예   금");
				System.out.println("--------");
				System.out.print("계좌번호: ");
				String dep_acFind=sc.nextLine();
				for(Account20 accountInfo : acArr) {
					if(accountInfo!=null) {
						if(dep_acFind.equals(accountInfo.getAccount())) {
							System.out.print("예금액: ");
							accountInfo.deposit(sc.nextInt());
							System.out.println("입금 후 계좌");
							System.out.println(accountInfo);
						}
					} else break;
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("--------");
				System.out.println(" 출   금");
				System.out.println("--------");
				System.out.print("계좌번호: ");
				String wit_acFind=sc.nextLine();
				for(Account20 accountInfo:acArr) {
					if(accountInfo!=null) {
						if(wit_acFind.equals(accountInfo.getAccount())) {
							System.out.print("출금액: ");
							accountInfo.withdraw(sc.nextInt());
							System.out.println("출금 후 계좌");
							System.out.println(accountInfo);
						}
					} else break;
				}
				break;
			case 5:
				System.out.println("프로그램 종료");
				run=false;
				break;
			}
		}
		sc.close();
	}

}

class Account20{
	private String account;
	private String name;
	private int balance;
	public Account20(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}
	public String getAccount() {
		return this.account;
	}
	public void deposit(int dep) {
		this.balance+=dep;
	}
	public void withdraw(int wit) {
		if(this.balance<wit) System.out.println("잔액부족");
		else this.balance-=wit;
	}
	@Override
	public String toString() {
		return this.account+"   "+this.name+"   "+this.balance;
	}
}