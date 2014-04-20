package com.pvt;
import java.io.Serializable;
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private Integer category;
	private String title;
	private String annotation;
	private String author;
	private String creationdate;
	private String content;
	private String id;
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
	
}
