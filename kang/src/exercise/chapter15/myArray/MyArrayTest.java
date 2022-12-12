package exercise.chapter15.myArray;

public class MyArrayTest {

	public static void main(String[] args) {
		MyArray arr = new MyArray();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		
		arr.printAll();
		System.out.println("=========");
		arr.insert(1, 50);
		arr.printAll();
		
		System.out.println("=========");
		arr.remove(1);
		arr.printAll();
		System.out.println("=========");
		
		arr.add(70);
		arr.printAll();
		System.out.println("=========");
		arr.remove(1);
		arr.printAll();
		
		System.out.println("=========");
		System.out.println(arr.get(2));

	}

}
