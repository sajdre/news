package com.pvt.daoEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NEWS")
@SequenceGenerator(name = "PK", sequenceName = "CAT_SEQ")
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", updatable = false, insertable = false)
    private Category category;
    @Column(name = "title")
    private String title;
    @Column(name = "annotation")
    private String annotation;
    @Column(name = "author")
    private String author;
    @Column(name = "creationdate")
    private String creationdate;
    @Column(name = "content")
    private String content;
    @Column(name = "category_id")
    private Integer category_id;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return category + "\n" + creationdate + "\n" + author + "\n" + title + "\n" + annotation + "\n" + content + "\n";
	}
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(obj instanceof News)
				{
					News news = (News)obj;
					if(id.equals(news.id))
						return true;
					else
						return false;
				}
				else
					return false;
		}
	@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return id.hashCode();
		}


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
