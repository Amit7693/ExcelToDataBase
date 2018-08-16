package com.amit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerTransactions")
public class CustomerTransactions implements Serializable{

	
	private static final long serialVersionUID = 9170059723915034067L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custTx;
	
	@Column
	private String MSISDN;
	private String PanEncrypted;
	private int Amount;
	private String Channel;
	private String TransactionType;
	private String PaymentItem;
	private String MerchantBiller;
	private String CardBrand;
	private String AcquirerBank;
	private String IssuerBank;
	private String TransactionDate;
	private String TransactionTime;
	private String ResponseCode;
	private String ExtraData;
	
	public CustomerTransactions() {
		super();
	}

	public CustomerTransactions(String mSISDN, String panEncrypted, int amount, String channel, String transactionType,
			String paymentItem, String merchantBiller, String cardBrand, String acquirerBank, String issuerBank,
			String transactionDate, String transactionTime, String responseCode, String extraData) {
		super();
		MSISDN = mSISDN;
		PanEncrypted = panEncrypted;
		Amount = amount;
		Channel = channel;
		TransactionType = transactionType;
		PaymentItem = paymentItem;
		MerchantBiller = merchantBiller;
		CardBrand = cardBrand;
		AcquirerBank = acquirerBank;
		IssuerBank = issuerBank;
		TransactionDate = transactionDate;
		TransactionTime = transactionTime;
		ResponseCode = responseCode;
		ExtraData = extraData;
	}

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

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getPaymentItem() {
		return PaymentItem;
	}

	public void setPaymentItem(String paymentItem) {
		PaymentItem = paymentItem;
	}

	public String getMerchantBiller() {
		return MerchantBiller;
	}

	public void setMerchantBiller(String merchantBiller) {
		MerchantBiller = merchantBiller;
	}

	public String getCardBrand() {
		return CardBrand;
	}

	public void setCardBrand(String cardBrand) {
		CardBrand = cardBrand;
	}

	public String getAcquirerBank() {
		return AcquirerBank;
	}

	public void setAcquirerBank(String acquirerBank) {
		AcquirerBank = acquirerBank;
	}

	public String getIssuerBank() {
		return IssuerBank;
	}

	public void setIssuerBank(String issuerBank) {
		IssuerBank = issuerBank;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return TransactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		TransactionTime = transactionTime;
	}

	public String getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}

	public String getExtraData() {
		return ExtraData;
	}

	public void setExtraData(String extraData) {
		ExtraData = extraData;
	}

	@Override
	public String toString() {
		return "CustomerTransactions [MSISDN=" + MSISDN + ", PanEncrypted=" + PanEncrypted + ", Amount=" + Amount
				+ ", Channel=" + Channel + ", TransactionType=" + TransactionType + ", PaymentItem=" + PaymentItem
				+ ", MerchantBiller=" + MerchantBiller + ", CardBrand=" + CardBrand + ", AcquirerBank=" + AcquirerBank
				+ ", IssuerBank=" + IssuerBank + ", TransactionDate=" + TransactionDate + ", TransactionTime="
				+ TransactionTime + ", ResponseCode=" + ResponseCode + ", ExtraData=" + ExtraData + "]";
	}
	
	
}
