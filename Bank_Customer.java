package org.project1;

public class Bank_Customer 
{
	long accno;
	float balance;
	String name,address;
	public Bank_Customer()
	{
		return;
	}
	public Bank_Customer(long accno, String name, String address,float balance)
	{
		super();
		this.accno = accno;
		this.name = name;
		this.address = address;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account number : " + accno + "\nName of the Customer : " + name + "\nAddress of the Customer : " + address + "\nBalance  : "+balance+"\n------------------------------------------------------------";
	}
}