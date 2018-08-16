package com.amit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CustomerTransactionMessages")
public class CustomerTransactionMessages implements Serializable {

	private static final long serialVersionUID = -6373789711999442106L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String Identifier;
	private String MSISDN;
	private String Info;
	private String Date;
	private String Message;
	
//	 @OneToMany(cascade=CascadeType.ALL)
//     @JoinColumn(name = "MSISDN", nullable = false)
//     private Set<A_B_C> abc;
//	

	public CustomerTransactionMessages() {
		super();
	}

	public CustomerTransactionMessages(String identifier, String mSISDN, String info, String date,
			String message) {
		super();
		Identifier = identifier;
		MSISDN = mSISDN;
		Info = info;
		Date = date;
		Message = message;
	}

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	

//	public Set<A_B_C> getAbc() {
//		return abc;
//	}
//
//	public void setAbc(Set<A_B_C> abc) {
//		this.abc = abc;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerTransactionMessages [ID=" + ID + ", Identifier=" + Identifier + ", MSISDN=" + MSISDN + ", Info="
				+ Info + ", Date=" + Date + ", Message=" + Message + "]";
	}

}
