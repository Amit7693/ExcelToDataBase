package com.amit.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CustomerData")
public class CustomerData implements Serializable {

	private static final long serialVersionUID = -3443039252452491281L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custData;
	
	@Column
	private String MSISDN;
	private String PanEncrypted;
	private String CustormerName;
	private String AccountNumber;
	private String Email;
	private String RecordTimeStamp;

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public String getPanEncrypted() {
		return PanEncrypted;
	}

	public void setPanEncrypted(String panEncrypted) {
		PanEncrypted = panEncrypted;
	}

	public String getCustormerName() {
		return CustormerName;
	}

	public void setCustormerName(String custormerName) {
		CustormerName = custormerName;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRecordTimeStamp() {
		return RecordTimeStamp;
	}

	public void setRecordTimeStamp(String recordTimeStamp) {
		RecordTimeStamp = recordTimeStamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CustomerData() {
		super();
	}

	public CustomerData(String mSISDN, String panEncrypted, String custormerName, String accountNumber, String email,
			String recordTimeStamp) {
		super();
		MSISDN = mSISDN;
		PanEncrypted = panEncrypted;
		CustormerName = custormerName;
		AccountNumber = accountNumber;
		Email = email;
		RecordTimeStamp = recordTimeStamp;
	}

	@Override
	public String toString() {
		return "CustomerData [MSISDN=" + MSISDN + ", PanEncrypted=" + PanEncrypted + ", CustormerName=" + CustormerName
				+ ", AccountNumber=" + AccountNumber + ", Email=" + Email + ", RecordTimeStamp=" + RecordTimeStamp
				+ "]";
	}

}
