package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity   
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountNumber")
	private int accId;
	
	@Column(name=" AccountName")
	private String accountHolderName;
	
	//@Temporal(TemporalType.TIMESTAMP) used only for java.util.Date (old date api)
	private LocalDate openningDate;
	
	@Embedded
	private Address address;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "houseNumber",column = @Column(name="office_Address")),
		@AttributeOverride(name = "cityName",column = @Column(name="office_cityName")),
		@AttributeOverride(name = "state",column = @Column(name="office_state")),
	})
	private Address office_address;
	
	
	//--------  Collection Has-a Relation----
	
	@ElementCollection
	@CollectionTable(name="PolicyInfo",joinColumns = @JoinColumn(name="AccountNumber"))
	List<Policy> policies;

	
	private int balance;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="taxfile_id",referencedColumnName = "fileId")
	private TaxationFile taxfile;

	
	
	
		public TaxationFile getTaxfile() {
		return taxfile;
	}


	public void setTaxfile(TaxationFile taxfile) {
		this.taxfile = taxfile;
	}


		public List<Policy> getPolicies() {
		return policies;
	}


	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}





	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public LocalDate getOpenningDate() {
		return openningDate;
	}

	public void setOpenningDate(LocalDate openningDate) {
		this.openningDate = openningDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getOffice_address() {
		return office_address;
	}

	public void setOffice_address(Address office_address) {
		this.office_address = office_address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accountHolderName=" + accountHolderName + ", openningDate=" + openningDate
				+ ", address=" + address + ", office_address=" + office_address + ", balance=" + balance + "]";
	}

	
	

	
	
	
	

}
