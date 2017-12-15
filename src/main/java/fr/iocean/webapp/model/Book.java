package fr.iocean.webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.iocean.webapp.validator.Isbn;

@Entity
@Table(name="book")
public class Book {
	@Id
	int id;
	
	@NotNull
	@Column
	String title;
	
	@NotNull
	@Column(name="nb_pages")
	int nbPages;
	
	@Column
	String description;
	
	@Column
	Set<String> keywords=new HashSet<String>();
	
	@Isbn
	private String isbn; 
	
	public Book(int id, String title, int nbPages, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.nbPages = nbPages;
		this.isbn=isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book() {
		super();
	}
	
	public void add(String... kws){
		for(String keyword:kws)keywords.add(keyword);
	}
	
	public boolean matches(String s){
		for(String kw: keywords)if(kw.toLowerCase().indexOf(s.trim())>=0) return true;
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", nbPages=" + nbPages + ", description=" + description+ ", keywords=" + keywords + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getNbPages() {
		return nbPages;
	}
	
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}
	
	

}
