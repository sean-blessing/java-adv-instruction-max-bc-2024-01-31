package ui;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Printable;
import model.Product;
import model.Software;


public class ProductManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the product manager app!");

		// Create a couple of products
//		Product p1 = new Product("java", "Murach's Java Programming", 59.5);
//		Product p2 = new Product("andr", "Murach's Android Programming", 62.5);
//		
//		List<Product> products = new ArrayList<>();
//		products.add(p1);
//		products.add(p2);
		
		// Create a couple of products
		Book b1 = new Book("java", "Murach's Java Programming", 59.5, "Joel Murach");
		Book b2 = new Book("andr", "Murach's Android Programming", 62.5, "Mike Murach");
		
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);

		for (Book b: books) {
			System.out.println(b);
		}
		
		// Create a couple of software instances
		Software s1 = new Software("netb", "Netbeans", 0, "v1.1");
		Software s2 = new Software("ecl", "Eclipse", 0, "v7.2");
		
		List<Software> softwareList = new ArrayList<>();
		softwareList.add(s1);
		softwareList.add(s2);
		
		for (Software s: softwareList) {
			System.out.println(s);
		}
		
		//Product prod = new Product("test", "test", 5);
		List<Product> products = new ArrayList<>();
		products.add(b1);
		products.add(b2);
		products.add(s1);
		products.add(s2);
		
		System.out.println("Product loop:");
		for (Product p: products) {
			System.out.println(p);
		}
		
		List<Printable> prodList = new ArrayList<>();
		prodList.add(b1);
		prodList.add(b2);
		prodList.add(s1);
		prodList.add(s2);
		
		System.out.println("Printable loop:");
		for (Printable p: prodList) {
			p.print();
		}
		
		System.out.println("bye");
	}

}
