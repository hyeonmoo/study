package exercise0926;

import java.util.Arrays;

public class Member implements Cloneable {
	public String id;
	public int[] scores;
	
	public Member(String id) {this.id=id;}
	public Member(String id, int...scores) {
		this.id = id;
		this.scores=scores;
	}
	
	@Override public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member=(Member) obj;
			if(id.equals(member.id)) return true;
		}
		return false;
	}
	@Override public int hashCode() {return this.id.hashCode();} //문자열이 같으면 같은 해시코드가 반환
	@Override public String toString() {return "멤버이름: "+this.id;} //객체의 유용한 정보를 리턴

	@Override protected Object clone() throws CloneNotSupportedException{
		Member cloned=(Member) super.clone(); //Object.clone()
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length); //scores필드가 참조하는 배열까지도 복제
		return cloned;
	}
	public Member getMember() {
		Member cloned=null;
		try {cloned=(Member) clone();}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
