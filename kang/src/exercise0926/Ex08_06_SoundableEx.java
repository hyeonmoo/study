package exercise0926;

public class Ex08_06_SoundableEx {
	public static void printSound(Soundable soundable) {System.out.println(soundable.sound());}
	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());

	}

}
interface Soundable{public String sound();}
class Cat implements Soundable{public String sound() {return "야옹";}}
class Dog implements Soundable{public String sound() {return "멍멍";}}