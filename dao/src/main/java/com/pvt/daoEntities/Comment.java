package com.pvt.daoEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_COMMENTS")
@SequenceGenerator(name = "PK", sequenceName = "T_COMMENTS_SEQ")
public class Comment implements Serializable {
    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "F_NEWS_ID", updatable = false, insertable = false)
    News news;

    @ManyToOne
    @JoinColumn(name = "F_USER_ID", updatable = false, insertable = false)
    User user;
    @Column(name = "F_DATE")
    String date;
    @Column(name = "F_NUMBER")
    Integer number;
    @Column(name = "F_COMMENT")
    String comment;
    @Column(name = "F_NEWS_ID")
    Integer news_id;
    @Column(name = "F_USER_ID")
    String user_id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        if (date != null ? !date.equals(comment1.date) : comment1.date != null) return false;
        if (id != null ? !id.equals(comment1.id) : comment1.id != null) return false;
        if (news != null ? !news.equals(comment1.news) : comment1.news != null) return false;
        if (number != null ? !number.equals(comment1.number) : comment1.number != null) return false;
        if (user != null ? !user.equals(comment1.user) : comment1.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (news != null ? news.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
