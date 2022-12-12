package exercise.chapter14;

import java.util.function.ToIntFunction;

public class Q06 {

	private static Student[] students= {
			new Student("홍길동",90,96),
			new Student("신용권",95,93)
	};
	
	private static double avg( ToIntFunction<Student> func) {
		int sum = 0;
		for(Student stu : students) {
			sum += func.applyAsInt(stu);
		}
		double average = (double)sum/students.length;
		return average;
	}
	
	public static void main(String[] args) {
		double engAvg = avg(s -> s.getEngS());
		System.out.printf("영어 평균 점수 : %.1f점\n", engAvg);
		
//		double mathAvg = avg(Student :: getMathS);
//		System.out.printf("수학 평균 점수 : %.1f점\n", mathAvg);
		
//		ToIntFunction<Student> func = s->s.getMathS();
		ToIntFunction<Student> func = Student :: getMathS;
		double mathAvg = avg(func);
		System.out.printf("수학 평균 점수 : %.1f점\n", mathAvg);

	}
	
	public static class Student{
		private String name;
		private int engS;
		private int mathS;
		public Student(String name, int engS, int mathS) {
			this.name = name;
			this.engS = engS;
			this.mathS = mathS;
		}
		public String getName() {
			return name;
		}
		public int getEngS() {
			return engS;
		}
		public int getMathS() {
			return mathS;
		}
	}

}