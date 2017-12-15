package fr.iocean.webapp.model;

import java.util.ArrayList;
import java.util.List;


public class Library {

	public static Library instance=null;
	public static Library getInstance(){
		if(instance!=null) return instance;
		else instance = new Library();
		return instance;
	}
	
	private ArrayList<Book> list = new ArrayList<Book>();
	
	public boolean addBook(Book b){
		if(list.contains(b.getId())) return false;
		list.add(b);
		return true;
	}
	
	public boolean removeBook(int id){
		for (Book b : list)if(b.getId()==id){
			list.remove(b);
			return true;
		}
		return false;
	}
	
	public ArrayList<Book> search(String criteria){
		ArrayList<Book> result = new ArrayList<Book>();
		for(Book b: list)if(b.matches(criteria.toLowerCase()))result.add(b);
		return result;
	}
	
	
	public boolean contains(int id){
		return getById(id)!=null;
	}
	
	public Book getById(int id){
		for (Book b : list)if(b.getId()==id) return b;
		return null;
	}
	
	public List<Book> getAll(){
		return list;
	}
	
	private Library(){
		Book b = new Book(1000, "Java premier langage", 237, "2123654789");
		list.add(b);
		b.add("Java", "Programmation");

		b = new Book(1001, "Jquery", 480, "75849632158769");
		list.add(b);
		b.add("Javascript", "Programmation", "Web");

		b = new Book(1002, "CSS Maintenable", 123, "16584973658416");
		list.add(b);
		b.add("CSS", "Web", "Saas", "Compass");

		b = new Book(1003, "J2EE without EJB", 846, "1046837946");
		list.add(b);
		b.add("Java", "Programmation");
	}
	
}
