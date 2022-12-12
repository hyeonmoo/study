package exercise.chapter15;

import java.util.Comparator;
import java.util.TreeSet;

public class Q10 {

	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<>(new MaxScoreComparator());
		ts.add(new Student("blue",96));
		ts.add(new Student("hong",86));
		ts.add(new Student("white",92));
		
		Student st = ts.last();
		System.out.println("최고점수: "+st.score);
		System.out.println("최고점수를 받은 아이디: "+st.id);
		
		System.out.println();
		for(Student i : ts) {
			System.out.printf("%s: %d\n", i.id,i.score);
		}

	}

}

class Student {
	public String id;
	public int score;
	public Student(String id, int score) {
		this.id = id;
		this.score = score;
	}
//	@Override
//	public int compareTo(Student o) {
//		if(score<o.score) return -1;
//		else if(score==o.score) return 0;
//		else return 1;
//	}
	
}

class MaxScoreComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.score<o2.score) return -1;
		else if(o1.score==o2.score) return 0;
		else return 1;
	}
	
}