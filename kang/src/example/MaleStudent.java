package example;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
	private List<Student> list;
	
	public MaleStudent() {
		list = new ArrayList<>();
		System.out.printf("[ %s ] MaleStudent()\n", Thread.currentThread().getName());
	}
	
	public void accumulate(Student student) {
		list.add(student);
		System.out.printf("[ %s ] accumulate()\n", Thread.currentThread().getName());
	}
	
	public void combine(MaleStudent other) {
		list.addAll(other.getList());
		System.out.printf("[ %s ] combine()\n", Thread.currentThread().getName());
	}
	
	public List<Student> getList(){
		return list;
	}
}
