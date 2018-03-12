package main.java.com.unico.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import main.java.com.unico.dao.UserDao;
import main.java.com.unico.hibernate.model.User;
import main.java.com.unico.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Override
	public User getUser(String userName, String password) throws Exception {
		Session s = HibernateUtil.getSession();  
			
			return (User) s.createQuery(" from User where userName=:user and password=:password").setParameter("user", "userName").setParameter("password", password).uniqueResult();
	}

}
