package main.java.com.unico.pubSub;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import main.java.com.unico.processor.JMSMessageProcessor;

/*
 * Used for Message Receving from a queue
 * Assumption - The server - tcp://localhost:61616 and the queue name are not there but assumed to be existent
 * 
 */

@Service("listener")
public class JmsQueueListener implements MessageListener{
	
	private JMSMessageProcessor jmsProcessor;
	
	@Override
	public void onMessage(Message arg0) {
		ConnectionFactory factory =  new ActiveMQConnectionFactory("tcp://localhost:61616"); 

		Connection con  = null;

		try {
			
			con = factory.createConnection();
		  Session session =  con.createSession(false, Session.AUTO_ACKNOWLEDGE);

		  Queue queue = session.createQueue("INPUT.QUEUE"); 
		  
		  MessageConsumer consumer = session.createConsumer(queue);
		  
		  con.start();                                            
		  while (true) {                                     
		    Message msg = consumer.receive();                    
		    if (! (msg instanceof TextMessage))
		      throw new RuntimeException("Expected a TextMessage");
		    jmsProcessor.processMessage(msg);		    
		      
		  }			  
		}
		catch(JMSException e)
		{
			System.err.println("Exception while reading message from the queue "+e.getMessage());
		}
		
	}

	
   @Autowired
   @Qualifier("jmsProcessor")
	public void setJmsProcessor(JMSMessageProcessor jmsProcessor) {
		this.jmsProcessor = jmsProcessor;
	}
	

}




