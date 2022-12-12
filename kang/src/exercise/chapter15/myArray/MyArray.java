package exercise.chapter15.myArray;

public class MyArray {
	//배열과 COUNT 변수 선언
	int[] intArr;
	int count;
	//배열의 크기 변수 선언
	public int ARRAY_SIZE;
	//에러메시지 생성
	public static final int ERROR_NUM = -999999999;
	
	//생성자 생성(매개변수 없을 때, 매개변수로 배열의 크기가 주어질 때)
	public MyArray() {
		count = 0;
		ARRAY_SIZE = 10;
		intArr = new int[ARRAY_SIZE];
	}
	
	public MyArray(int size) {
		count = 0;
		ARRAY_SIZE = size;
		intArr = new int[size];
	}
	
	//요소 추가 함수 선언
	public void add(int num) {
		if(count >= ARRAY_SIZE) {
			System.out.println("NOT ENOUGH MEMORY");
			return;
		}
		intArr[count++] = num;
	}
	
	//요소 삽입 함수 선언
	public void insert(int position, int num) {
		int i;
		if(count >= ARRAY_SIZE) {
			System.out.println("NOT ENOUGH MEMORY");
			return;
		}
		if(position < 0 || position > count) {
			System.out.println("INSERT POSITION ERROR");
			return;
		}
		
		for(i=count-1; i>= position; i--) {
			intArr[i+1] = intArr[i];
		}
		intArr[position] = num;
		count++;
	}
	
	//요소 제거 함수 선언
	public int remove(int position) {
		int i;
		int ret = ERROR_NUM;
		
		if(isEmpty()) {
			System.out.println("THERE IS NO ELEMENT");
			return ret;
		}
		if(position < 0 || position > count) {
			System.out.println("POSITION ERROR");
			return ret;
		}
		
		ret = intArr[position];
		
		for(i=position;i<count-1;i++) {
			intArr[i] = intArr[i+1];
		}
		count--;
		return ret;
	}
	
	//빈 배열인지 여부 반환
	public boolean isEmpty() {
		if(count <= 0) return true;
		return false;
	}
	
	//배열의 크기 반환
	public int size() {
		return count;
	}
	
	//해당 위치의 요소 반환
	public int get(int position) {
		if(position<0||position>count-1) {
			System.out.printf("SEARCH POSITION ERROR-LIST:%dELEMENTS\n",count);
			return ERROR_NUM;
		}
		return intArr[position];
	}
	
	public void printAll() {
		if(count==0) {
			System.out.println("출력할 내용이 없습니다.");
			return;
		}
		for(int i=0;i<count;i++) {
			System.out.println(intArr[i]);
		}
	}
	
	public void removeAll() {
		for(int i=0;i<count;i++) {
			intArr[i]=0;
		}
		count=0;
	}
}
