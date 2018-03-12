/**
 * 
 */
package main.java.com.unico.processor;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import main.java.com.unico.dao.InputNumberDao;
import main.java.com.unico.hibernate.model.InputNumber;

/**
 * @author Sonam
 *
 */
@Service("jmsProcessor")
public class JMSMessageProcessor {
	
	public static Deque<Integer> qu = new ArrayDeque<Integer>();
	
	private InputNumberDao servDao;
	
	public void processMessage(Message msg)
	{
		TextMessage tm = (TextMessage) msg;
		
		int input = 0;
		try {
			input = Integer.valueOf(tm.getText());
			qu.add(input);	
			
			//Add the numbers to the Database
			InputNumber inputObj = new InputNumber();
			inputObj.setInput(input);
			servDao.saveInputNumbers(inputObj);
			
			
		} catch (NumberFormatException e) {
			System.err.println("Error while converting to Integer "+e.getMessage());
		} catch (JMSException e) {
			System.err.println("Error while casting to TextMessage "+e.getMessage());
		}
		
		
	}

	
	@Autowired
	@Qualifier("inputNumberDao")
	public void setServDao(InputNumberDao servDao) {
		this.servDao = servDao;
	}

}
