//package com.amit.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="A_B_C")
//public class A_B_C {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int abcID;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "MSISDN", nullable = false, insertable=false, updatable=false)
//    private CustomerData customerData;
//
//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "MSISDN", nullable = false, insertable=false, updatable=false)
//    private CustomerTransactions customerTransactions;
//
//	public CustomerData getCustomerData() {
//		return customerData;
//	}
//
//	public void setCustomerData(CustomerData customerData) {
//		this.customerData = customerData;
//	}
//
//	public CustomerTransactions getCustomerTransactions() {
//		return customerTransactions;
//	}
//
//	public void setCustomerTransactions(CustomerTransactions customerTransactions) {
//		this.customerTransactions = customerTransactions;
//	}
//
//	@Override
//	public String toString() {
//		return "A_B_C [customerData=" + customerData + ", customerTransactions=" + customerTransactions + "]";
//	}
//    
//    
//}
