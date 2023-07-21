package com.Mypackage;

import java.util.*;

class BankAccount {
	
	String name;
	String pin;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void registration() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name : ");
		this.name = sc.nextLine();
		
		System.out.print("\nEnter Your pin : ");
		this.pin= sc.nextLine();
		System.out.print("\nEnter Your Account Number : ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration completed..Go to login");
	}
	
	public boolean pin() {
		boolean flage=false;
		Scanner sc=new Scanner(System.in);
		String p=sc.nextLine();
		if(p.equals(pin)){
			System.out.println("\nCorrectly entered pin...\n");
			flage=true;
			return flage;
		}else{
			System.out.println("\nIncorrectly entered pin...\n");
			return flage;
		}
		
	}
	
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry\nonly 100000 amount for withdraw ");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name : ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer : ");
		float transferamount = sc.nextFloat();
		try {
			if ( balance >= transferamount ) {
				if ( transferamount <= 50000f ) {
					transactions++;
					balance -= transferamount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = transferamount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry\nonly 50000 amout for transfer");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}

	public void balance(){
		System.out.println("Your account balance is:"+balance);
	}
}


public class Atm_interface {
	

	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("\n-----WELCOME-----\n");
		System.out.println("1.Registration \n2.Exit");
		System.out.println("enter the choice 1 or1 2 : ");
		int choice=s.nextInt();
		if(choice<1 || choice>2)
		{
			System.out.println("Wrong choice!!!");
			System.exit(0);
		}
		if ( choice == 1 ) {
			BankAccount b = new BankAccount();
			b.registration();
			while(true) {
				System.out.println("\n1.EnterPin \n2.Exit");
				System.out.print("Enter Your Choice  1 or 2  : ");
				int ch=s.nextInt();
				if(ch<1 || ch>2)
				{
					System.out.println("Wrong choice!!!");
					System.exit(0);
				}
				if ( ch == 1 ) {
					if (b.pin()) {
						System.out.println("\n<<<>>>  LOGIN SUCCESSFULLY  <<<>>>\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice between 1 to 6 : ");
							int c=s.nextInt();
							if(c<1 || c>6)
							{
								System.out.println("Wrong choice!!!");
								System.exit(0);
							}
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.balance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.out.print("Tank you !!");
					System.exit(0);
				}
			}
		}
		else {
			System.out.print("Tank you !!");
			System.exit(0);
		}	
	}
}
