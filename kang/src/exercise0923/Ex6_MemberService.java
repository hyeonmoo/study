package exercise0923;

public class Ex6_MemberService {
	public static void main(String[] args) {
		MemberService ms = new MemberService();
		boolean result = ms.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			ms.logout("hong");
		} else System.out.println("로그인 정보가 맞지 않습니다.");
	}
}

class MemberService{
	private String id;
	private String pw;
	
	public MemberService() {
		this.id="hong";
		this.pw="12345";
	}
	
	public boolean login(String id, String pw) {
		if(id.equals(this.id)&&pw.equals(this.pw)) return true;
		else return false;
	}
	public void logout(String id) {
		System.out.println(id+"님이 로그아웃 하셨습니다.");
	}
}