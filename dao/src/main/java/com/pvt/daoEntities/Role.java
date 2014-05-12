package com.pvt.daoEntities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "T_ROLES")
@SequenceGenerator(name = "PK", sequenceName = "T_ROLES_SEQ")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "F_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer id;
    @Column(name = "F_ROLE_NAME")
    private String role;
    @ManyToMany(mappedBy = "roles")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<User> users;

    @Override
    public String toString() {
        return role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role roles = (Role) o;

        if (!id.equals(roles.id)) return false;
        if (!role.equals(roles.role)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

}
