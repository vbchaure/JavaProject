package org.project1;
import java.util.*;

public class CollectionExample
{
	float balance;
	String address,name;
	long acc;
	static HashSet<Bank_Customer> ls=new HashSet<Bank_Customer>();
	List<Float> l=new ArrayList<Float>();
	static HashMap<Long,List<Float>> ls1=new HashMap<Long,List<Float>>();
	public void create(Bank_Customer obj)
	{
		List<Float> a=new ArrayList<Float>();
		acc=(long)(Math.random()*999999999+1000000000);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name of the Bank Account Holder :");
		name=sc.nextLine();
		System.out.println("enter Current address :");
		address=sc.nextLine();
		System.out.println("enter Account Balance ( Greater than 1000 ) :");
		balance=sc.nextFloat();
		if(balance<1000)
		{
			System.out.println("Deposite amount should be greater than 1000 to create account .");
			sc.close();
			return;
		}
		obj=new Bank_Customer(acc,name,address,balance);
		ls.add(obj);
		a.add(balance);
		ls1.put(acc, a);
		System.out.println("Please note down Account Number for Future Use.");
		display(acc);
	}
	public void deposite(long acc,float val)
	{
		List<Float> a=new ArrayList<Float>();
		int m=0;
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				m=1;
				b.balance+=val;
				a=ls1.get(acc);
				a.add(val);
				ls1.put(acc,a);
				System.out.println("Your Money Deposited Successfully .");
			}
		}
		if(m==0)
		{
			System.out.println("Please Enter Your Correct Account Number");
		}
		
	}
	public void withdraw(long acc,float val)
	{
		List<Float> a=new ArrayList<Float>();
		int m=0;
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				m=1;
				if(b.balance>=(1000+val))
				{
					b.balance-=val;
					a=ls1.get(acc);
					val=0-val;
					a.add(val);
					ls1.put(acc,a);
					System.out.println("Your Money withdrawn Successfully .");
					System.out.println("If this transaction is not performed by you then report bank imidiately within 2 working days.");
				}
				else
				{
					System.out.println("Transaction Unsuccessful..!! Please maintain 1000 rs minimum balance .");
				}
			}
		}
		if(m==0)
		{
			System.out.println("Please Enter Your Correct Account Number");
		}
	}
	public void Transfer_Money(long acc,long R_acc,float val)
	{
		List<Float> a=new ArrayList<Float>();
		int m=0,n=0;
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				m=1;
				if(b.balance>=(1000+val))
				{
					for(Bank_Customer b1:ls)
					{
						if(b1.accno==R_acc)
						{
							n=1;
							b1.balance+=val;
							a=ls1.get(R_acc);
							a.add(val);
							ls1.put(R_acc,a);
							b.balance-=val;
							a=ls1.get(acc);
							val=0-val;
							a.add(val);
							ls1.put(acc,a);
							System.out.println("Money is withdrawn Successfully from "+acc+" account number and deposited to account number "+R_acc);
							System.out.println("If this transaction is not performed by you then report bank imidiately within 2 working days.");
						}
					}
				}
				else
				{
					System.out.println("Transaction Unsuccessful..!! Please maintain 1000 rs minimum balance .");
				}
			}
		}
		if(m==0)
		{
			System.out.println("Please Enter Senders Account Number Correct.");
			return;
		}
		if(n==0)
		{
			System.out.println("Please Enter Receivers Account Number Correct.");
		}
		
	}
	public void display(long acc)
	{
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				System.out.println(b);
			}
		}
	}
	public void displayAll()
	{
		Iterator<Bank_Customer> itr=ls.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	public void display_transaction(long acc)
	{
		List<Float> a=new ArrayList<Float>();
		a=ls1.get(acc);
		for(float i:a)
		{
			if(i>0)
			{
				System.out.println("Credited amount is "+i);
			}
			else
			{
				System.out.println("Debited amount is "+-(i));
			}
		}
	}
	public static void main(String[] args)
	{
		//System.out.println(ls);
		int i=0;
		int ch;
		CollectionExample cl=new CollectionExample();
		Bank_Customer[] ob=new Bank_Customer[10000];
		do
		{
			System.out.println("-------------Start Menu---------------");
			System.out.println(" 1.Create Account (Press 1) ");
			System.out.println(" 2.Deposite Money (Press 2) ");
			System.out.println(" 3.Withdraw Money (Press 3) ");
			System.out.println(" 4.Display Account Details By giving Account number (Press 4) ");
			System.out.println(" 5.Display All Accounts Details (Press 5) ");
			System.out.println(" 6.Display Transaction Details By giving Account number (Press 6) ");
			System.out.println(" 7.Transfer Money Using Account number (Press 7) ");
			System.out.println("-------------End Menu---------------");
			int n;
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			switch(n)
			{
				case 1: cl.create(ob[i]);
						i++;
						break;
				case 2: System.out.println("Enter Account Number : ");
						long acc=sc.nextLong();
						System.out.println("Enter Amount To be Deposited : ");
						float val=sc.nextFloat();
					    cl.deposite(acc,val);
					    break;
				case 3: System.out.println("Enter Account Number : ");
						long acc1=sc.nextLong();
						System.out.println("Enter Amount To be Withdrawn : ");
						float val1=sc.nextFloat();
						cl.withdraw(acc1, val1);
						break;
				case 4: System.out.println("Enter Account Number : ");
				        long acc2=sc.nextLong();
				        cl.display(acc2);
				        break;
				case 5: cl.displayAll();
						break;
				case 6: System.out.println("Enter Account Number : ");
		        		long acc3=sc.nextLong();
		        		cl.display_transaction(acc3);
		        		break;
				case 7: System.out.println("Enter Sender Account Number : ");
        				long acc4=sc.nextLong();
        				System.out.println("Enter Receivers Account Number : ");
        				long acc5=sc.nextLong();
        				System.out.println("Enter Amount To be Transfered : ");
						float val2=sc.nextFloat();
						cl.Transfer_Money(acc4, acc5, val2);
						break;
				default: System.out.println("Please Enter Correct Choice");
			}
			System.out.println("Please Select '1' for Continuing the bank process and to exit press '0' :");
			ch=sc.nextInt();
		}while(ch==1);
		
	}
}

