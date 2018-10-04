package org.cap.demo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainMethod {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Ënter the no.of customers");
int size=scan.nextInt();
		ArrayList<Customer> cust=new ArrayList<Customer>();
		ArrayList<Account> account=new ArrayList<Account>();	
		Transactions trans=new Transactions();
		ArrayList<Transactions> tran=new ArrayList<Transactions>();
		int choice=0;
		int p=0;
		

		for(int i=0;i<size;i++)
		{
			System.out.println("---------------Enter  Customer details-------------");
			System.out.println("Enter The CustomerId:");
			Pattern pattern=Pattern.compile("^([0-9]{6,10})$");
			long n=scan.nextLong();
			boolean z=true;
		Matcher match=pattern.matcher(Long.toString(n));
			while(z)
			{
				if(match.find())
				{
					System.out.println("Valid Id");
					z=false;
				}
				else {
				System.out.println("Customer Id should be min 6 and max 10 digits");
				System.out.println("Enter The CustomerId:");
				n=scan.nextLong();}
			}
			System.out.println("Enter Customer Name: ");
			String s=scan.next();
			boolean f=true;
			while(f)
			{
				if(s.matches("^([a-zA-Z]+)$"))
				{
					System.out.println("Valid Name");

					f=false;
				}
				else {
				System.out.println("Customer Name should contain only alphabets");
				System.out.println("Enter The Customer Name:");
				 s=scan.next();
				}
			}
			 Address a=new Address();
			 System.out.println("Enter Customer street Name:");
				String stn=scan.next();
				
		 System.out.println("Enter Customer Address:");
          String add=scan.next();
			
			 System.out.println("Enter Customer city Name:");
				String city=scan.next();
				
				 System.out.println("Enter Customer state Name:");
					String state=scan.next();
				
			System.out.println("Enter Customer Mobile No: ");
			String phno=scan.next();
			boolean z1=true;
			while(z1)
			{
				if(phno.matches("^([1-9][0-9]{9})$"))
				{
					System.out.println("Valid Phone Number");

					z1=false;
				}
				else {
				System.out.println("Phone Number contains 10 digits");
				System.out.println("Enter The Customer PhoneNo:");
				 phno=scan.next();
				}
			}
			System.out.println("Enter Customer EmailId: ");
			String email=scan.next();
			boolean f1=true;
			while(f1)
			{
				if(email.matches("^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,6})$"))
				{
					System.out.println("Valid EmailId");

					f1=false;
				}
				else {
				System.out.println("Invalid Email Id");
				System.out.println("Enter The Customer emailId:");
				 email=scan.next();
				}
			}
			a.setStName(stn);
			 a.setAddress(add);
			 a.setCity(city);
			 a.setState(state);
		
			cust.add(new Customer(n,s, a, phno,email));
			
			
		}
		String s="";
		do{
			
		System.out.println("Choose An Option");
		System.out.println("1.Genertate Account \n2.Do Transaction \n3.Transaction Summary \n4.Display Customer Details");
		int ch=scan.nextInt();
		
		Account[] acc;
		switch(ch)
		{
		case 1:
			String c="";
			
			int j=0,m=0;
			do{
				System.out.println("Give the customerId");
				int custId=scan.nextInt();
				for(int i=0;i<size;i++)
				{
					if(cust.get(i).getCustomerId()==custId)
					{
						m=i;
						cust.get(i).setAccount(acc);
					
				
			System.out.println("--------Enter Account Details-----");
			
			 acc[j]=new Account();
			System.out.println("Enter Account Number");
			int accountNo=scan.nextInt();
			Pattern p1=Pattern.compile("^([0-9]{3,6})$");
			Matcher match1=p1.matcher(Integer.toString(accountNo));
			boolean v=true;
			while(v)
			{
				if(match1.find())
				{
					System.out.println("Valid  Account no");
					v=false;
				}
				else {
				System.out.println("Account Number should contain Min 3 and max 6 digits");
				System.out.println("Enter The Customer Name:");
				accountNo=scan.nextInt();
				}
			}
			acc[j].setAccountNo(accountNo);
			System.out.println("Choose Account Type");
			System.out.println("1.Savings \n2.Current \n3.RD  \n4.FD");
			int atype=scan.nextInt();
			String accountType="";
			switch(atype)
			{
			case 1:
				accountType="Savings";
				break;
			case 2:
				accountType="Current";
				break;
			case 3:
				accountType="RD";
				break;
			case 4:
				accountType="FD";
				break;
				default :
					System.out.println("Enter valid Account Type");
					break;
			}
			acc[j].setAccountType(accountType);
			LocalDate date= LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		      System.out.println(formatter.format(date));  
			acc[j].setOpeningDate(date);
			System.out.println("Enter Account openingBalance");
			double bal=scan.nextDouble();
			acc[j].setOpeningBalance(bal);
			System.out.println("Want to generate another Account [Y|N]");
			c=scan.next();
		      j++;
		      cust.get(m).setAccountCount(j);
					}
					else
					{
						System.out.println("CustomerId does not exist");
						break;
						
					}
				}
		     
			}while(c.charAt(0)=='y'||c.charAt(0)=='Y'||c.charAt(0)==' ');
			
			break;
			
			
									
		case 2:
			System.out.println("Give the customerId");
			int custId=scan.nextInt();
			
			for(int i=0;i<size;i++)
			{
				
				if(cust.get(i).getCustomerId()==custId)
				{ 
					trans.setAccount(acc[choice]);
					System.out.println("Enter Transaction Id");
					int transId=scan.nextInt();
					trans.setTransactionId(transId);
					LocalDate d=LocalDate.now();
					trans.setTransactionDate(d);
					System.out.println("Choose Transaction type");
					System.out.println("1.Debit \n2.Credit");
					int trancho=scan.nextInt();
					String transtype="";
					switch(trancho)
					{
					case 1:
						transtype="Debit";
						break;
					case 2:
						transtype="Credit";
						break;
						default:
							System.out.println("Transaction not feesible");
							break;
						
					}
					trans.setTransactionType(transtype);
					System.out.println("Enter Amount to be Transacted ");
					double transam=scan.nextDouble();
					
					trans.setTransactionAmount(transam);
					
						     	//System.out.println(k);
					int  k=cust.get(i).getAccountCount();
							for(int t=0;t<k;t++)
							{
								System.out.println("Choose account "+t+" "+cust.get(i).get1AccountNo(t));
							   
							}
						   choice=scan.nextInt();
						   
						   if(choice<=k)
						   {
							   if(transtype=="Debit")
							   transam=acc[choice].getOpeningBalance()-transam;
							   else
								   transam=acc[choice].getOpeningBalance()+transam;

							   acc[choice].setOpeningBalance(transam);
								System.out.println("----Transaction Summary For given CustomerId------");
							   System.out.println("TransactionId "+trans.getTransactionId()+"\tTransaction Type "+trans.getTransactionType()+"\tTransactionAmount "+trans.getTransactionAmount()+"\tBalance is: "+acc[choice].getOpeningBalance()+"\tAccount No"+acc[choice].getAccountNo());
							  

							   trans.setTransCount(p);
							   tran.add(new Transactions(transId,transtype,acc[choice]));
							  tran[p]=new Transactions();
							  tran[p].setTransactionId(transId);
							  tran[p].setTransactionType(transtype);
							  tran[p].setAccount(acc[choice]);
							
							  p++;
							   
						   }	
					
					
					
				}
				else
				{
					System.out.println("CustomerId does not exist");
				}
				
			}
			
			
			break;
		case 3:
			System.out.println("----Transaction Summary For given CustomerId------");
			System.out.println("Give the customerId");
			int custId2=scan.nextInt();
			//System.out.println(tran.getTransCount());
			System.out.println("TransactionId\t TransactionType\t Account No\t Transactes Amount\tCurrentBalance");

			for(int i=0;i<size;i++)
			{
				
				if(cust.get(i).getCustomerId()==custId2)
				{ 
					for(int t=0;t<tran.length-1;t++)
					System.out.println(tran[t].getTransactionId()+" \t"+tran[t].getTransactionType()+" \t"+tran[t].getAccount().getAccountNo()+" \t"+tran[t].getTransactionAmount()+" \t"+tran[t].getAccount().getOpeningBalance());
					
				}
				else {
					System.out.println("Customer Doesnot exist");
				}
			}
			
				
			break;
		case 4:
			System.out.println("Customer and respective Account details");
			System.out.println("Give the customerId");
			int custId1=scan.nextInt();
			int k=0;
			for(int i=0;i<size;i++)
			{
				
				if(cust.get(i).getCustomerId()==custId1)
				{
					 k=cust.get(i).getAccountCount();
				     	//System.out.println(k);
					 
					System.out.println(cust.get(i).getCustomerId()+" \t"+cust.get(i).getCustomerName()+" \t"+cust.get(i).getEmailId()+" \t"+cust.get(i).getMobileNo()+" \t");
					for(int t=0;t<k;t++)
					{
						System.out.println("Account "+cust.get(i).get1AccountNo(t));
					}
				    
				}				
				else
				{
					System.out.println("CustomerId does not exist");
					//System.exit(0);
					
				}
				
			}
			break;
		       default :
				break;
				
		}
		 
		System.out.println("Want to Repeat [Y|N]");
		s=scan.next();
		}while(s.charAt(0)=='Y'|| s.charAt(0)=='y');
		
		System.out.println("Have a Good Day");
	}
	

}
