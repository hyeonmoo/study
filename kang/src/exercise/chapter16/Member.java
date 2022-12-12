package exercise.chapter16;

public class Member {
	private String name;
	private int age;
	private String job;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Member(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getJob() {
		return job;
	}
}
