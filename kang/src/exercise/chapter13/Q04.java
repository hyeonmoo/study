package exercise.chapter13;

public class Q04 {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair,"홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 30);
		Integer childAge = Util.getValue(childPair,"홍삼순");
		System.out.println(childAge);

	}

}

class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}

class ChildPair<K,V> extends Pair<K,V>{
	public ChildPair(K k, V v) {
		super(k,v);
	}
}

class Util{
	public static <P extends Pair<K,V>,K,V> V getValue(P p,K k) {
		if(p.getKey()==k) return p.getValue();
		else return null;
	}
}