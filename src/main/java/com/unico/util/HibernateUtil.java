package main.java.com.unico.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*
 * Database Utility class for interacting with the database
 * Assumption - the DB Details mentioned in the hibernate.cfg.xml are assumed
 * 
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;   

	 static {
	        try {
	            Configuration configuration = new Configuration()
	                    .configure("hibernate.cfg.xml");
	            	            
	            sessionFactory = configuration.configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	  
	    /**
	     * Returns an instance of the Session Factory;
	     * @return 
	     */
	    public static SessionFactory getSessionFactory() {          
	        return sessionFactory;
	    }
	    
	    /**
	     * Returns a Session created by the Session Factory
	     * @return 
	     */
	    public static Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	     
	

}
