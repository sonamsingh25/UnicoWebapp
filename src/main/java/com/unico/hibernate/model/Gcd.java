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
@Table(name = "Gcd")
public class Gcd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GcdId")
	private int gcdId;
	
	@Column(name="Gcd")
	private int gcd;

	public int getGcd() {
		return gcd;
	}

	public void setGcd(int gcd) {
		this.gcd = gcd;
	}

	public int getGcdId() {
		return gcdId;
	}

	public void setGcdId(int gcdId) {
		this.gcdId = gcdId;
	}
	
	
}
