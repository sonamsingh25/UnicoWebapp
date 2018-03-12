package main.java.com.unico.processor;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import main.java.com.unico.dao.InputNumberDao;

/*
 * The Service class interacting with the DAO interface as well as the Publisher-Subscriber interface
 * 
 */

@Service("unicoProcessor")
public class UnicoProcessor {
	
	private InputNumberDao inputNumberDao;
	 
         public List<Integer> getInputList() throws Exception
         {
        	 
        	 List<Integer> inputNumberList = new ArrayList<Integer>();
        	 
        	try {
			      inputNumberList.addAll(inputNumberDao.getInputNumbers());
			} catch (Exception e) {
				
				System.err.println("Error while getting the list from the database"+e);
			}
        	 
        	 return inputNumberList;      	 
          
        	 
         }

        @Autowired
        @Qualifier("inputNumberDao")
		public void setInputNumberDao(InputNumberDao inputNumberDao) {
			this.inputNumberDao = inputNumberDao;
		}
         
        

}
