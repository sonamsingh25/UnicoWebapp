package main.java.com.unico.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import main.java.com.unico.dao.UserDao;

@Service("soapAuth")
public class SOAPUserAuthenticationImpl {
	
	private UserDao serviceDao;

	
	public boolean isValidUser(String userName, String password) {
		
		try {
			return serviceDao.getUser(userName, password) != null ? true : false;
		} catch (Exception e) {
			System.err.println("Exception while getting user from the database"+e.getMessage());
		}
		
		return false;
	
	}

	
	@Autowired
	@Qualifier("userDao")
	public void setServiceDao(UserDao serviceDao) {
		this.serviceDao = serviceDao;
	}
	
	

}
