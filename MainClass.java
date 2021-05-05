package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MainClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Account a = new Account();
		
		  
		  a.setAccountHolderName("Ramesh");
		  a.setBalance(2000);
		  a.setOpenningDate(LocalDate.now());
		  
		  Address address = new Address(123, "New Delhi", "Delhi");
		  a.setAddress(address);
		  
		  Address officeaddress = new Address(4848, "New Delhi", "Delhi");
		  a.setOffice_address(officeaddress);
				  
		  
		  Policy p1 = new Policy("Policy-A", 100, 2000);
		  Policy p2 = new Policy("Policy-B", 200, 3000);
		  Policy p3 = new Policy("Policy-C", 300, 4000);
		  
		  List<Policy> policyList = Arrays.asList(p1,p2,p3);
		  
		  
		  a.setPolicies(policyList);
		  
		  TaxationFile tf = new TaxationFile("bhjbhj287y",2000, LocalDate.now());
		  a.setTaxfile(tf);;
		  //---------- Save Objec --------
		  
		  Object x = session.save(a); // insert into Account .....
		  System.out.println(x.toString());
		  System.out.println("  -->> Data Saved ..");
		  
		
		  //--- get 
		  System.out.println("==============================================");
		  Account account = (Account)session.get(Account.class, 1);
		  
		  System.out.println("\n Account Info :- "+account);
		  System.out.println("\n Tax Info From Account "+account.getTaxfile());
		  System.out.println("\n Tax file ID "+account.getTaxfile().getFileId());
		  
		 // TaxationFile file = session.get(TaxationFile.class, account.getTaxfile().getFileId());
		 // System.out.println("\n Tax File "+file);
		 // System.out.println("\n Account Info From Tax File "+file.getAccounts());
		 

			
		t.commit();
		
		
		
		
		
		session.close();
		System.out.println("All Done");
		
		
	}
}
