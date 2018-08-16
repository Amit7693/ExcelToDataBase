package com.amit.service;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.model.CustomerData;
import com.amit.model.CustomerTransactionMessages;
import com.amit.model.CustomerTransactions;

@Service
public class FileUploadService {
	
	@Autowired
	com.amit.dao.FileUpdateDAO fileUpdateDAO;

	@SuppressWarnings("deprecation")
	public void uploadFileData(Workbook wb, String type){
		
		String mSISDN=null;
		String panEncrypted=null;
		String accountNumber=null;
		int amount=0;
		String transactionType=null;
		String channel=null;
		String paymentItem=null;
		String merchantBiller=null;
		String cardBrand=null;
		String acquirerBank=null;
		String issuerBank=null;
		String transactionDate=null;
		String transactionTime=null;
		String responseCode=null;
		String extraData=null;	
		
		Workbook workbook=null;
		Sheet sheet=null;
		
		if(type.equals("XSSF")){
		workbook=(XSSFWorkbook)wb;
		}
		
		if(type.equals("HSSF")){
			workbook=(HSSFWorkbook)wb;
		}
		try{
//			workbook=new XSSFWorkbook(filePath);
			
			int sheet_count=workbook.getNumberOfSheets();
			System.out.println("****sheet_count "+sheet_count);
			
			sheet=workbook.getSheetAt(0);
			Row row;
			int no=sheet.getLastRowNum();
			System.out.println("****row last num "+no);
			for(int i=1;i<=sheet.getLastRowNum();i++){		//starting of excel
				row=sheet.getRow(i);
					
				try{
					mSISDN=row.getCell(0).toString();
					panEncrypted=row.getCell(1).toString();
					accountNumber=row.getCell(2).toString();
					amount=row.getCell(3).CELL_TYPE_NUMERIC;
					transactionType=row.getCell(4).toString();
					channel=row.getCell(5).toString();
					paymentItem=row.getCell(6).toString();
					merchantBiller=row.getCell(7).toString();
					cardBrand=row.getCell(8).toString();
					acquirerBank=row.getCell(9).toString();
					issuerBank=row.getCell(10).toString();
					transactionDate=row.getCell(11).toString();
					transactionTime=row.getCell(12).toString();
					responseCode=row.getCell(13).toString();
					extraData=row.getCell(14).toString();
					if(extraData==null || extraData=="")
						extraData="NULL";
				}catch(Exception e){
					e.printStackTrace();
				}
//					System.out.println();
//					System.out.println(i);
//					System.out.println();
//					System.out.println(mSISDN);
//					System.out.println(panEncrypted);
//					System.out.println(accountNumber);
//					System.out.println(amount);
//					System.out.println(transactionType);
//					System.out.println(channel);
//					System.out.println(paymentItem);
//					System.out.println(merchantBiller);
//					System.out.println(cardBrand);
//					System.out.println(acquirerBank);
//					System.out.println(issuerBank);
//					System.out.println(transactionDate);
//					System.out.println(transactionTime);
//					System.out.println(responseCode);
//					System.out.println(extraData);
					
					CustomerData custData=new CustomerData(mSISDN, panEncrypted, null, accountNumber, null, null);
					CustomerTransactionMessages TxMsg=new CustomerTransactionMessages(null, mSISDN, null, null, null);
					CustomerTransactions custTx=new CustomerTransactions(mSISDN, panEncrypted, amount, channel, transactionType, paymentItem, merchantBiller, cardBrand, acquirerBank, issuerBank, transactionDate, transactionTime, responseCode, extraData);
					
					fileUpdateDAO.addCustomerData(custData);
					fileUpdateDAO.addCustomerTransactionMessages(TxMsg);
					fileUpdateDAO.addCustomerTransactions(custTx);

				
	}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
