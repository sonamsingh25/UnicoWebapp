package main.java.com.unico.dao;

import java.util.List;

import main.java.com.unico.hibernate.model.InputNumber;
import main.java.com.unico.hibernate.model.User;


/*
 * DAO Class used by the services for fetching data from the database
 */

public interface ServiceDao {

		public List<Integer> getInputNumbers()  throws Exception;	
		
		public List<Integer> getListGcd() throws Exception;
		
		
		public User getUser(String userName , String password) throws Exception;
		
		public void saveInputNumbers(InputNumber input);
		
		
	}
	
	


