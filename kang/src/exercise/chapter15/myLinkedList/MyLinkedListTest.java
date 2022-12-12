package exercise.chapter15.myLinkedList;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addElement("A");
		list.addElement("B");
		list.addElement("C");
		list.addElement("D");
		list.addElement("E");
		list.addElement("F");
		list.addElement("G");
		list.addElement("H");
		list.addElement("I");
		list.addElement("J");
		list.printAll();
		
		list.insertElement(5, "Z");
		list.printAll();
		
		list.removeElement(0);
		list.printAll();
		list.removeElement(1);
		list.printAll();
		
		list.insertElement(0, "A-1");
		list.printAll();
		System.out.println(list.getSize());
		
		list.removeElement(0);
		list.printAll();
		System.out.println(list.getSize());
		
		list.removeAll();
		list.printAll();
		list.addElement("A");
		list.printAll();
		System.out.println(list.getElement(0));
		list.removeElement(0);
	}

}
