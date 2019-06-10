package net.codejava.model;

import java.util.Calendar;
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
@Table(name = "tb_author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_author")
	private Long id;
	@NotNull(message = "This field name not be empty")
	private String name;
	private String style;
	private Calendar dateBirth;
	
	//@Expose(serialize = true, deserialize = false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private transient List<Book> listBooks;
	
	public Author() {
	}
	public Author(Long id, String name, String style, Calendar dateBirth) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.dateBirth = dateBirth;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Calendar getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Calendar dateBirth) {
		this.dateBirth = dateBirth;
	}
	public List<Book> getListBooks() {
		return listBooks;
	}
	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}
}
