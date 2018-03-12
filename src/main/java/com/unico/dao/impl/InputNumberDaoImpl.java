package main.java.com.unico.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.unico.dao.InputNumberDao;
import main.java.com.unico.hibernate.model.InputNumber;
import main.java.com.unico.util.HibernateUtil;

@Repository("inputNumberDao")
public class InputNumberDaoImpl implements InputNumberDao{

	@Override
	@Transactional
	public void saveInputNumbers(InputNumber input) {
		
		Session s = HibernateUtil.getSession();  
		s.save(input);		
		
		
	}
	
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
}
