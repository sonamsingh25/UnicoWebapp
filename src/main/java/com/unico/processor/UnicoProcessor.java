package main.java.com.unico.processor;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Service;

import main.java.com.unico.dao.ServiceDao;
import main.java.com.unico.dao.impl.ServiceDaoImpl;


/*
 * The Service class interacting with the DAO interface as well as the Publisher-Subscriber interface
 * 
 */

@Service("unicoProcessor")
public class UnicoProcessor {
	 
         public List<Integer> getInputList() throws Exception
         {
        	 ServiceDao serviceDao = new ServiceDaoImpl();
        	 List<Integer> inputNumberList = new ArrayList<Integer>();
        	 
        	try {
			      inputNumberList.addAll(serviceDao.getInputNumbers());
			} catch (Exception e) {
				
				System.err.println("Error while getting the list from the database"+e);
			}
        	 
        	 return inputNumberList;      	 
          
        	 
         }
         
        

}
