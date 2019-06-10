package net.codejava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@XmlRootElement
@Entity
@Table(name = "tb_book")
//@CacheEvict
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_book")
	private Long   id;
	
	@NotNull(message = "This field title not be empty")
	private String title;
	
	@NotNull(message = "This field  publication year not be empty")
	private Long   yearPublication;
	
	private String description;

	//@NotNull(message = "This field publication number not be empty")
	//private Long   issueNumber;
	
	@NotNull(message = "This field edition not be empty")
	private Long   editionNamber;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_publishingCompany")
	private PublishingCompany publishingCompany;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "This field category not be empty")
	private TypeBook category;
	
	@ManyToOne(cascade=CascadeType.PERSIST) 
	@JoinColumn(name = "id_author")
	private Author author;
	
	@NotNull(message = "This field real value not be empty")
	private Double realValue;
	
	@NotNull(message = "This field discount not be empty")
	private Double discountValue;
	
	@NotNull(message = "This field tota not be empty")
	private Long  total;
	
	private boolean visible;
	
	//@Lob
    //@Column(columnDefinition = "BYTEA") 
	//@Column(columnDefinition = "oid")
	//@Size(max = 3000)
    private byte[] thumbnail; 
	
	public Book() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getYearPublication() {
		return yearPublication;
	}
	public void setYearPublication(Long yearPublication) {
		this.yearPublication = yearPublication;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
//	public Long getIssueNumber() {
//		return issueNumber;
//	}
//	public void setIssueNumber(Long issueNumber) {
//		this.issueNumber = issueNumber;
//	}
	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TypeBook getCategory() {
		return category;
	}
	public void setCategory(TypeBook category) {
		this.category = category;
	}
	public Double getRealValue() {
		return realValue;
	}
	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}
	public Double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public boolean isVisible() {
		if(total != null && total.intValue() == 0) {
			visible = false;
		}else {
			visible = true;
		}
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Long getEditionNamber() {
		return editionNamber;
	}
	public void setEditionNamber(Long editionNamber) {
		this.editionNamber = editionNamber;
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
}
