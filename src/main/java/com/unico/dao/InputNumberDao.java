package main.java.com.unico.dao;

import java.util.List;

import main.java.com.unico.hibernate.model.InputNumber;

public interface InputNumberDao {
	
	public void saveInputNumbers(InputNumber input);
	
	public List<Integer> getInputNumbers()  throws Exception;	
}
