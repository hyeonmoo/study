package examples.chapter14;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class Example05 {

	public static void main(String[] args) {
		Consumer<String> cons = t -> System.out.println(t+"8");
		cons.accept("java");
		
		BiConsumer<String, String> bicons = (t,u)-> System.out.println(t+u);
		bicons.accept("java", "tutorials");
		
		DoubleConsumer dbcons = t-> System.out.println(t);
		dbcons.accept(8.0);
		
		

	}

}
