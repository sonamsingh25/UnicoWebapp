package main.java.com.unico.dao;

import main.java.com.unico.hibernate.model.User;

public interface UserDao {

	public User getUser(String userName , String password) throws Exception;
}
