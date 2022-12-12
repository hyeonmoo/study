package lawofjava.ch06;

public class Ex06_345 {

	public static void main(String[] args) {
		Student s=new Student();
		s.name="홍길동";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;
		
		System.out.println("이름: "+s.name);
		System.out.println("총점: "+s.getTotal());
		System.out.println("평균: "+s.getAverage());
		System.out.println();
		
		Student k = new Student("강현무",3,1,100,60,76);
		System.out.println(k.info());
	}

}

class Student{
	public String name;
	public int ban,no,kor,eng,math;
	
	public Student() {}
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getTotal() {return this.kor+this.eng+this.math;}
	public float getAverage() {
		int totalScore=this.getTotal();
		return Float.parseFloat(String.format("%.1f", totalScore/3.0));
	}
	public String info() {
		return this.name+","+this.ban+","+this.no+","+this.kor+","+this.eng+","+this.math+","+this.getTotal()+","+this.getAverage();
	}
}