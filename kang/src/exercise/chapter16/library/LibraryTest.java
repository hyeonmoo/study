package exercise.chapter16.library;

import java.util.ArrayList;
import java.util.List;

class Book{
	private String name;
	private int price;
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
}

public class LibraryTest {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 15000));
		bookList.add(new Book("안드로이드", 30000));
		
		int totalPrice = bookList.stream()
				.mapToInt(Book::getPrice)
				.sum();
		System.out.println("모든 책의 가격의 합: "+totalPrice);
		
		System.out.println();
		System.out.println("::20000원 이상인 책 목록::");
		bookList.stream()
		.filter(s->s.getPrice()>=20000)
		.map(Book::getName)
		.sorted()
		.forEach(System.out::println);
	}

}
