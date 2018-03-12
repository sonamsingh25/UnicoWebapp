package main.java.com.unico.controller;

import org.springframework.web.bind.annotation.RestController;



import main.java.com.unico.processor.UnicoProcessor;
import main.java.com.unico.pubSub.JmsQueuePublisher;
import main.java.com.unico.response.RestResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/*
 * Class for the REST Web Service
 * @Path /unico
 * Has two methods - push and list
 * push - pushes the input value to an ActiveMQ
 * list - lists all the numbers from a database *  
 */


@RestController
@RequestMapping("/unico")
public class UnicoRest {
	 
	 private static final String SUCCESS_STATUS = "success";
	 private static final String ERROR_STATUS = "error";
	 
	 private RestResponse restResponse;
	 
	 private UnicoProcessor serv;

	
	    @RequestMapping(value = "/push", method = RequestMethod.GET)	    
		public String  push(@RequestParam("param1") int i, @RequestParam("param2") int d) {			
			JmsQueuePublisher pub = JmsQueuePublisher.getInstance();	
			try
			{
			
			pub.sendMessage(i);
			pub.sendMessage(d); 
			
			return SUCCESS_STATUS;
			}
			catch(Exception e)
			{
				System.err.println("Exception while sending message to the queue "+e.getMessage());
				return ERROR_STATUS;
				
			}		
		}
	 
		
	  
	    @RequestMapping(value = "/list", method = RequestMethod.GET)			
		public RestResponse list() {
	    	 
	    try {
				restResponse.setStatus(SUCCESS_STATUS);
				restResponse.setListOfInput(serv.getInputList());
				
			} catch (Exception e) {
				
				restResponse.setStatus(ERROR_STATUS);				
				System.err.println("Error while parsing "+e.getMessage());
			}
	    	
	    	
	    	return restResponse;
			
		}



	    @Autowired
	    @Qualifier("restResponse")
		public void setRestResponse(RestResponse restResponse) {
			this.restResponse = restResponse;
		}


	    @Autowired
	    @Qualifier("unicoProcessor")
		public void setServ(UnicoProcessor serv) {
			this.serv = serv;
		}
		
		
	}


