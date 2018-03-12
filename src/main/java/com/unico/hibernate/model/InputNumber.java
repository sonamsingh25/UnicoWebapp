/**
 * 
 */
package main.java.com.unico.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sonam
 *
 */
@Entity
@Table(name = "InputNumbers")
public class InputNumber implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InputNumberId")
	private int inputNumberId;
	
	public int getInputNumberId() {
		return inputNumberId;
	}

	public void setInputNumberId(int inputNumberId) {
		this.inputNumberId = inputNumberId;
	}

	@Column(name="input")
	private int input;

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

}
