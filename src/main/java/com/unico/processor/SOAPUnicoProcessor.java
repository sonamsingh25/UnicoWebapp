package main.java.com.unico.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import main.java.com.unico.dao.GcdDao;

import main.java.com.unico.dao.impl.GcdDaoImpl;



@Service("soapProcessor")
public class SOAPUnicoProcessor {
		
	 
    public synchronized int getLargestCommonDivisor()
    {       	
   	
   	if(JMSMessageProcessor.qu.size()> 0)
   	{
   	Set<Integer> divSet = new  HashSet<Integer>();        	
   	
   	int i = JMSMessageProcessor.qu.remove();
   	int d = JMSMessageProcessor.qu.remove();
   	
   	for (int j =2; j < Math.min(i, d); j++ )
   	{
   		if(i%j == 0 && d%j ==0)
   			divSet.add(j);
   	}
   	
   	return Collections.max(divSet);
   	}
   	
   	else
   		return 0;
   	
    }
    
    
    
    public List<Integer> getListOfGcd()
    {
   	 List<Integer> listGcd = new ArrayList<Integer>();
   	 
   	 GcdDao serviceDao = new GcdDaoImpl();
   	 
   	 try {
			listGcd.addAll(serviceDao.getListGcd());
		} catch (Exception e) {
			System.err.println("Exception while getting list of divisors "+e);
			
		}        	 
   	 
   	 return listGcd;
    }
    
    
    public int getGcdSum()
    {
   	int sum = 0;       	 
   	 
   	GcdDao serviceDao = new GcdDaoImpl();
   	 
   	try {
			return serviceDao.getListGcd().stream().mapToInt(i -> i).sum();
		} catch (Exception e) {
			System.err.println("Exception while getting the data for Greatest Common Divisors from Database "+e);
		}
   	
   	return sum;
   	 
    } 
    
    
}
