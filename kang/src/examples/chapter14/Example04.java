package examples.chapter14;

public class Example04 {

	public static void main(String[] args) {
		OutterClass oc = new OutterClass();
		OutterClass.InnerClass ic = oc.new InnerClass();
		ic.method();

	}

}

@FunctionalInterface
interface MFI04{
	public void method();
}

class OutterClass{
	public int outterField = 10;
	
	class InnerClass{
		int innerField = 20;
		
		void method() {
			MFI04 fi = () -> {
				System.out.println(outterField);
				System.out.println(OutterClass.this.outterField);
				System.out.println();
				
				System.out.println(innerField);
				System.out.println(this.innerField);
				System.out.println();
			};
			fi.method();
		}
	}
}