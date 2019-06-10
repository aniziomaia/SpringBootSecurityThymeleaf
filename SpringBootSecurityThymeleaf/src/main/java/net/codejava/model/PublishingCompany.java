package net.codejava.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@XmlRootElement
//@XmlAccessorType()
@Entity
@Table(name = "tb_publishingcompany")
public class PublishingCompany {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_publishingcompany")
	private long id;
	@NotNull(message = "This field name not be empty")
	private String name;
	
	//@Expose(serialize = true, deserialize = false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publishingCompany")
	private transient List<Book> listBooks;
	
	public PublishingCompany() {
	}
	public PublishingCompany(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getListBooks() {
		return listBooks;
	}
	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}
	
}
