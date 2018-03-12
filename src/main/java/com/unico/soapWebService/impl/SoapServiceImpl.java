package main.java.com.unico.soapWebService.impl;


import main.java.com.unico.auth.impl.SOAPUserAuthenticationImpl;
import main.java.com.unico.processor.SOAPUnicoProcessor;
import main.java.com.unico.soapWebService.SoapService;

import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;

/*
 * Implementation class for SOAP Web Service
 */

@WebService(serviceName="unicoSoapService")
public class SoapServiceImpl implements SoapService{
	
	@Resource
    WebServiceContext wsctx;
	
	@SuppressWarnings("rawtypes")
	private boolean validateUser()
	{
	MessageContext mctx = wsctx.getMessageContext();

	   //get detail from request headers        
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String userName = "";
        String password = "";

        if(userList!=null){        	
        	userName = userList.get(0).toString();
        }

        if(passList!=null){        	
        	password = passList.get(0).toString();
        }

        SOAPUserAuthenticationImpl auth = new SOAPUserAuthenticationImpl();
       
		return auth.isValidUser(userName, password);
	
	}


	@WebMethod(operationName="getGcd")
	public int getGcd()
	{  
		if(validateUser())
		{
	     SOAPUnicoProcessor serv = new SOAPUnicoProcessor();		
	     return serv.getLargestCommonDivisor();
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return 0;
		
		
	}

	
	@WebMethod(operationName="getGcListFromDB")
	public Integer[] getGcdList() {
		if(validateUser())
		{		
			SOAPUnicoProcessor serv = new SOAPUnicoProcessor();
		Integer[] arr = serv.getListOfGcd().stream().toArray(Integer[]::new);
		return arr;
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return null;
		
	}
	

	@WebMethod(operationName="getGcdSum")
	public int getGcdSum() {
		if(validateUser())
		{
	    SOAPUnicoProcessor serv = new SOAPUnicoProcessor();
		return serv.getGcdSum();		
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return 0;
	}
   
}

