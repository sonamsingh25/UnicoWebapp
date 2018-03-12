package main.java.com.unico.auth.impl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import main.java.com.unico.dao.UserDao;
import main.java.com.unico.hibernate.model.User;

@Service("restAuth")
public class RestAuthenticationImpl{

    private UserDao servDao;

	public boolean authenticate(String authCredentials) throws Exception {
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			throw new Exception("Decoding failure.");
		}

		final String[] strArray = usernameAndPassword.split(":");

		User user = servDao.getUser(strArray[0],strArray[1]);	
	   return user != null ? true: false;
	}
	
	@Autowired
	@Qualifier("userDao")
	public void setServDao(UserDao servDao) {
		this.servDao = servDao;
	}

}
