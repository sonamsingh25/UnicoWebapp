package main.java.com.unico.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.unico.dao.ServiceDao;
import main.java.com.unico.hibernate.model.InputNumber;
import main.java.com.unico.hibernate.model.User;

import main.java.com.unico.util.HibernateUtil;

/*
 * ServiceDaoImpl implements the ServiceDao interface
 * Provides the method implementations for the interface
 * Used for any queries made to the database
 * 
 */

@Service("serviceDao")
public class ServiceDaoImpl implements ServiceDao{

	
		/*
		 * (non-Javadoc)
		 * @see main.java.com.unico.dao.ServiceDao#getInputNumbers()
		 * Gets the list of input numbers from the database
		 */
		@SuppressWarnings("unchecked")
		public List<Integer> getInputNumbers() throws Exception {
			
			Session s = HibernateUtil.getSession();  
			
			return (List<Integer>) s.createQuery("select input from InputNumber").list();
		}
		
		
		/*
		 * (non-Javadoc)
		 * @see main.java.com.unico.dao.ServiceDao#getListGcd()
		 * Gets the list of all greatest common divisors from the database
		 */
		@SuppressWarnings("unchecked")
		public List<Integer> getListGcd() throws Exception {
        Session s = HibernateUtil.getSession();  
			
			return (List<Integer>) s.createQuery("select gcd from Gcd").list();
		}


		@Override
		public User getUser(String userName, String password) throws Exception {
			Session s = HibernateUtil.getSession();  
				
				return (User) s.createQuery(" from User where userName=:user and password=:password").setParameter("user", "userName").setParameter("password", password).uniqueResult();
		}


		@Override
		@Transactional
		public void saveInputNumbers(InputNumber input) {
			
			Session s = HibernateUtil.getSession();  
			s.save(input);		
			
			
		}
	

}
