package exercise.print;

public class RandomArray {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}

		for(int i : arr) {
			System.out.printf("%d ",i);
		}
		System.out.println();
		
		for(int j=0; j<arr.length;j++) {
			for(int i=0; i<arr.length-1; i++) {
				num = arr[i];
				if(arr[i]<arr[i+1]) {
					arr[i]=arr[i+1];
					arr[i+1]=num;
				}
			}
		}
		
		for(int i : arr) {
			System.out.printf("%d ",i);
		}
		System.out.println();
		
		for(int j=0; j<arr.length;j++) {
			for(int i=0; i<arr.length-1; i++) {
				num = arr[i];
				if(arr[i]>arr[i+1]) {
					arr[i]=arr[i+1];
					arr[i+1]=num;
				}
			}
		}
		
		for(int i : arr) {
			System.out.printf("%d ",i);
		}
	}

}
