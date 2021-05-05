package com.capg.jpa.p1;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class TaxationFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;
	private String panNumber;
	private int taxSubmitted;
	private LocalDate submittedDate;
	
	@OneToOne(mappedBy = "taxfile")
	private Account accounts;
	
	public TaxationFile(String panNumber, int taxSubmitted, LocalDate submittedDate) {
		super();
		this.panNumber = panNumber;
		this.taxSubmitted = taxSubmitted;
		this.submittedDate = submittedDate;
	}
	
	
	
	public TaxationFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Account getAccounts() {
		return accounts;
	}



	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}



	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getTaxSubmitted() {
		return taxSubmitted;
	}
	public void setTaxSubmitted(int taxSubmitted) {
		this.taxSubmitted = taxSubmitted;
	}
	public LocalDate getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(LocalDate submittedDate) {
		this.submittedDate = submittedDate;
	}



	@Override
	public String toString() {
		return "TaxationFile [fileId=" + fileId + ", panNumber=" + panNumber + ", taxSubmitted=" + taxSubmitted
				+ ", submittedDate=" + submittedDate + ", accounts=" + accounts + "]";
	}
	
	
}
