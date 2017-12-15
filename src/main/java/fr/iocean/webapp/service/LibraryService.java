package fr.iocean.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.iocean.webapp.model.Book;

@Service
public class LibraryService {
	
	private static ArrayList<Book> list = new ArrayList<Book>();
	
	public static boolean addBook(Book b){
		if(list.contains(b.getId())) return false;
		list.add(b);
		return true;
	}
	
	public static boolean removeBook(int id){
		for (Book b : list)if(b.getId()==id){
			list.remove(b);
			return true;
		}
		return false;
	}
	
	public static ArrayList<Book> search(String criteria){
		ArrayList<Book> result = new ArrayList<Book>();
		for(Book b: list)if(b.matches(criteria.toLowerCase()))result.add(b);
		return result;
	}
	
	
	public static boolean contains(int id){
		return getById(id)!=null;
	}
	
	public static Book getById(int id){
		for (Book b : list)if(b.getId()==id) return b;
		return null;
	}
	
	public static List<Book> getAll(){
		return list;
	}
	
	private LibraryService(){
//		Book b = new Book(1000, "Java premier langage", 237, "2123654789");
//		list.add(b);
//		b.add("Java", "Programmation");
//
//		b = new Book(1001, "Jquery", 480, "75849632158769");
//		list.add(b);
//		b.add("Javascript", "Programmation", "Web");
//
//		b = new Book(1002, "CSS Maintenable", 123, "16584973658416");
//		list.add(b);
//		b.add("CSS", "Web", "Saas", "Compass");
//
//		b = new Book(1003, "J2EE without EJB", 846, "1046837946");
//		list.add(b);
//		b.add("Java", "Programmation");
	}
}
