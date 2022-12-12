package lawofjava.ch06;

public class Ex06_20 {
	private static int[] shuffle(int[] intArr) {
		java.util.ArrayList<Integer> al = new java.util.ArrayList<>();
		for(int num:intArr) al.add(num);
		int[] result=new int[intArr.length];
		for(int i=0;i<intArr.length;i++) {
			int randIndex=(int)(Math.random()*al.size());
			result[i]=al.get(randIndex);
			al.remove(randIndex);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] original= {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result= shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
