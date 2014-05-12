package com.pvt.daoEntities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USERS")
@SequenceGenerator(name = "PK", sequenceName = "T_USERS_SEQ")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "F_USER_ID")
	private String id;
    @Column(name = "F_PASSWORD")
	private String password;
    @Column(name = "F_NAME")
	private String name;
    @Column(name = "F_SECONDNAME")
	private String secondname;
    @OneToMany(mappedBy = "user")
    List<Comment> comments;
    @ManyToMany
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "T_ROLES_USERS", joinColumns = @JoinColumn(name = "F_USER_ID"), inverseJoinColumns = @JoinColumn(name = "F_ROLE_ID"))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addRole(Role role){
        List<Role> list = new ArrayList<Role>();
        list.add(role);
        this.roles = list;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\n" + password + "\n" + name + "\n" + secondname;
	}
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj instanceof User){
				User user = (User)obj;
				if(id.equals(user.id)){
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
}
