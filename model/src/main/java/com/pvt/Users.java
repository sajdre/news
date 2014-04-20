package com.pvt;

import java.io.Serializable;

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	private String secondname;
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\n" + password + "\n" + name + "\n" + secondname;
	}
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj instanceof Users){
				Users user = (Users)obj;
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
