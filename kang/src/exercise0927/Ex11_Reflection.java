package exercise0927;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex11_Reflection {

	public static void main(String[] args) throws Exception{
		Class cs = Class.forName("exercise0927.Car");
		
		System.out.println(" [클래스 이름]");
		System.out.println(cs.getName());
		System.out.println();
		
		System.out.println(" [생성자 정보]");
		Constructor[] csts = cs.getDeclaredConstructors();
		for(Constructor cst:csts) {
			System.out.print(cst.getName()+"(");
			Class[] pars = cst.getParameterTypes();
			printParameters(pars);
			System.out.println(")");
		}
		System.out.println();
		
		System.out.println(" [필드 정보]");
		Field[] fields = cs.getDeclaredFields();
		for(Field field:fields) System.out.println(field.getType().getSimpleName()+" "+field.getName());
		System.out.println();
		
		System.out.println(" [메소드 정보]");
		Method[] methods = cs.getDeclaredMethods();
		for(Method method:methods) {
			System.out.print(method.getName()+"(");
			Class[] pars=method.getParameterTypes();
			printParameters(pars);
			System.out.println(")");
		}
	}
	
	private static void printParameters(Class[] pars) {
		for(Class par:pars) System.out.print(par.getName());
	}
}
