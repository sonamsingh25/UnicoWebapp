/**
 * 
 */
package main.java.com.unico.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Sonam
 *
 */
@Service("restResponse")
public class RestResponse {
	
	private String status;
	
	private List<Integer> listOfInput = new ArrayList<Integer>();

	public List<Integer> getListOfInput() {
		return listOfInput;
	}

	public void setListOfInput(List<Integer> listOfInput) {
		this.listOfInput = listOfInput;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	

}
