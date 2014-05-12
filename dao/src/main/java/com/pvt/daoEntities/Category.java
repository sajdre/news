package com.pvt.daoEntities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_CATEGORIES")
@SequenceGenerator(name = "PK", sequenceName = "T_CATEGORIES_SEQ")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<News> news;
    @Column(name="F_CATEGORY")
	private String category;
    @Id
    @Column(name = "F_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Category){
			Category category = (Category)obj;
			if(id.equals(category.id)){
				return true;
			}
			return false;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\n" + category;
	}


    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
