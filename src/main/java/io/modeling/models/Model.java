package io.modeling.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "News")

public class Model {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "author")
	@NotNull
	private String author;
	
	@Column(name = "tekst")
	@NotNull
	private String tekst;
	
	@Column(name = "tags")
	@NotNull
	private String tags;
	
	@Column(name = "category")
	@NotNull
	private String category;
	
	public Model() {

	}
	public Model(int id, String author, String tekst, String tags, String category) {
		super();
		this.id = id;
		this.author = author;
		this.tekst = tekst;
		this.tags = tags;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTekst() {
		return tekst;
	}
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public String getTags() {
		return tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
