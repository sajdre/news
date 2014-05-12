package com.pvt.daoEntities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_NEWS")
@SequenceGenerator(name = "PK", sequenceName = "T_NEWS_SEQ")
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "F_NEWS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "F_CATEGORY_ID", updatable = false, insertable = false)
    private Category category;
    @Column(name = "F_TITLE")
    private String title;
    @Column(name = "F_ANNOTATION")
    private String annotation;
    @Column(name = "F_AUTHOR")
    private String author;
    @Column(name = "F_CREATIONDATE")
    private String creationdate;
    @Column(name = "F_CONTENT")
    private String content;
    @Column(name = "F_CATEGORY_ID")
    private Integer category_id;

    @OneToMany(mappedBy = "news")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OrderBy(value = "number")
    List<Comment> comments;
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
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
