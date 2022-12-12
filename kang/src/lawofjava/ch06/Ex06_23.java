package lawofjava.ch06;

public class Ex06_23 {
	private static int max(int[] arr) {
		int maxNum=0;
		try {
			if(arr.length==0) return -999999;
			for(int num:arr) if(maxNum<num) maxNum=num;
			return maxNum;
		} catch(Exception e) {
			return -999999;
		}
	}

	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값: "+max(data));
		System.out.println("최대값: "+max(null));
		System.out.println("최대값: "+max(new int[] {}));
	}

}
