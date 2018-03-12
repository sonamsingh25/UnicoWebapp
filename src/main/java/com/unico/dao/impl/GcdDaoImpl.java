package main.java.com.unico.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import main.java.com.unico.dao.GcdDao;
import main.java.com.unico.util.HibernateUtil;


@Repository("gcdDao")
public class GcdDaoImpl implements GcdDao{
	
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

}
