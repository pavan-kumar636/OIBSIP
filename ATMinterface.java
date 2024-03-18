import java.util.Scanner;

class ATMmachine {
	
	String name;
	String username;
	String password;
	String accountNo;
	float amount;
	int pin;
	float balance=0;
	int transactions=0;
	String transactionHistory = "";
	Scanner sc=new Scanner(System.in);
	
	public void Register(){
		
		System.out.println("Enter your Name: ");
		name=sc.nextLine();
		System.out.println("Create a new UserName:");
		username=sc.nextLine();
		System.out.println("Create a unique Password");
		password=sc.nextLine();
		System.out.println("Enter your Account Number:");
		accountNo=sc.nextLine();
		System.out.println("Create your Pin");
		pin=sc.nextInt();
		sc.nextLine();
		System.out.println("Your Registration Succesfully Completed");
		System.out.println("Please kindly Login...");
	}
	
	public boolean Login() {
		boolean isLogin=false;
		while(!isLogin) {
			System.out.println("Enter your UserName");
			String Username=sc.nextLine();
			
			if(Username.equals(username)) {
				while(!isLogin) {
					System.out.println("Enter your Password:");
					String Password=sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("Login Successful");
						isLogin=true;
					}
					else {
						System.out.println("Incorrect Password!");
					}
				}
			}
			else {
				System.out.println("Username Not found!");
			}
		}
		return isLogin;
	}
	
	public void deposit(){
		System.out.println("Enter amount to deposit:");
		amount=sc.nextFloat();
		sc.nextLine();
		 try {
			 System.out.println("Enter your Pin number:");
			 int Pin=sc.nextInt();
			 sc.nextLine();
			 if(Pin==pin) {
			   if(amount<=100000f) {
				  balance+=amount;
				  transactions++;
				  System.out.println("Successfully Deposited!");
				  String Sent="Rs." +amount + " deposited" +"\n";
				  transactionHistory=transactionHistory + Sent;
			   }
			   else {
				  System.out.println("Sorry... You can deposit only upto 100000");
			   }
		     }
			 else {
				 System.out.println("Incorrect Pin!");
			 }
			 
		 }
		 catch(Exception e) {
			 System.out.println("Please Enter amount in terms of Numbers!");
		 }
	 }
	
	public void withdraw(){
		System.out.println("Enter amount to withdraw");
		amount=sc.nextFloat();
		sc.nextLine();
		try {
			 System.out.println("Enter your Pin number:");
			 int Pin=sc.nextInt();
			 sc.nextLine();
			 if(Pin==pin) {
			   if(amount<=balance) {
				  balance-=amount;
				  transactions++;
				  System.out.println("Successfully Withdrawn!");
				  String Sent="Rs." +amount + " Withdrawn" +"\n";
				  transactionHistory=transactionHistory + Sent;
			   }
			   else {
				  System.out.println("Sorry... Insufficient balance!");
			   }
		     }
			 else {
				 System.out.println("Incorrect Pin!");
			 }
			 
		 }
		 catch(Exception e) {
			 System.out.println("Please enter amount in terms of Numbers!");
		 }
	}
	
	public void transfer(){
		System.out.println("Enter Receipent Name:");
		String receipent=sc.nextLine();
		System.out.println("Enter amount to tranfer:");
		amount =sc.nextFloat();
		sc.nextLine();
		try {
			System.out.println("Enter your Pin number");
			int Pin=sc.nextInt();
			if(Pin==pin) {
				if(amount<=balance){
					if(amount<=50000f) {
						balance-=amount;
						transactions++;
						System.out.println("Successfully transfered!");
						String Sent="Rs." +amount + " transfered to " +receipent +"\n";
						transactionHistory=transactionHistory + Sent;
					}
					else {
						System.out.println("Sorry.... limit is 50000!");
					}
				}
				else {
					System.out.println("Insufficient balance!");
				}
			}
			else {
				System.out.println("Incorrect Pin!");
			}
		}
		catch(Exception e) {
			System.out.println("Please enter amount in terms of Numbers!");
		}
		
	}
	
	public void checkBalance() {
		System.out.println("Enter your Pin:");
		int Pin=sc.nextInt();
		sc.nextLine();
		if(Pin==pin) {
			System.out.println("Your bank balance is:" +balance);
		}
		else {
			System.out.println("Incorrect Pin!");
		}
	}
	
	public void transHistory(){
		if(transactions==0) {
			System.out.println("Empty!");
		}
		else {
			System.out.println("Your Transaction History is :\n" + transactionHistory);
		}
	}
}


public class ATMinterface{
	
	public static int takeInput(int limit) {
		int input=0;
		boolean flag=false;
		
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				sc.nextLine();
				flag=true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter only numeric value!");
				flag=false;
			}	
		}
		return input;
	}
	
	public static void main(String[] args) {
		
		System.out.println("=======Welcome to Java ATM Machine=======");
		System.out.println("1.Register\n2.Exit");
		System.out.println("Enter your choice:");
		int choice=takeInput(2);
		
		if(choice==1) {
			ATMmachine atm=new ATMmachine();
			atm.Register();
			while(true) {
				System.out.println("1.Login\n2.Exit");
				System.out.println("Enter your choice:");
				int ch=takeInput(2);
				if(ch==1) {
					if(atm.Login()) {
						System.out.println("*****Welcome back "+atm.name+ "*****");
						boolean isFinished=false;
						while(!isFinished) {
							System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Check Balance\n5.Transaction History\n6.Exit\n");
							System.out.println("Enter your choice:");
							int c=takeInput(6);
							switch(c) {
							case 1:
								atm.deposit();
								break;
							case 2:
								atm.withdraw();
								break;
							case 3:
								atm.transfer();
								break;
							case 4:
								atm.checkBalance();
								break;
							case 5:
								atm.transHistory();
								break;
							case 6:
								isFinished=true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
			
	}
	
}


