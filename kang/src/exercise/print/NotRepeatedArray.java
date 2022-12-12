package exercise.print;

public class NotRepeatedArray {

	private static int[] randomArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		boolean repeated=true;
		int[] arr = new int[5];
		while(repeated) {
			int i;
			int j;
			boolean tf = true;
			arr = randomArray(arr);
			for(i=0;i<arr.length;i++) {	
				for(j=0;j<arr.length;j++) {
					if(i!=j) {
						if(arr[i]==arr[j]) {
							tf=false;
						}
					} 
				}					
			}
			if(tf) repeated=false;
		}
		for(int a:arr) {
			System.out.print(a+" ");
		}

	}

}
