import java.util.*;

public class NumberGuess {

	public static void main(String[] args) {
		
		int max_rounds=1;
		int points=0;
		System.out.println("*****Welcome to NumberGuess Game*****");
		System.out.println("Rules are:");
		System.out.println("There will be 3 rounds and each round has 10 attempts.");
		System.out.println("For each correct attempt you will be awarded by 1 point\n");
		
		while(max_rounds<=3) {
			
			int no_of_attempts=10;
			Random r=new Random();
			int systemNum=r.nextInt(101);
			
			System.out.println("Round "+max_rounds);
			System.out.println("Guess the number which is between 0 to 100");
			
			while(no_of_attempts>0) {
				
				Scanner sc=new Scanner(System.in);
				try {
					System.out.println("\nEnter your guess:");
					int userGuess=sc.nextInt();
					
					if(systemNum==userGuess) {
						System.out.println("Your Guess is correct\n");
						points++;
						break;
					}
					
					else if(systemNum<userGuess) {
						System.out.println("Your Guess is greater than my guess....Think again!");
						
					}
					
					else {
						System.out.println("Your Guess is smaller than my guess....Think again!");
					}
					
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input! Please enter a numeric value....");
					sc.nextLine();
				}
				
				no_of_attempts--;
				System.out.println("Remaining attempts : "+no_of_attempts+"\n");
					
			}
		max_rounds++;		
	  }
	System.out.println("Your points : "+points+" out of "+(max_rounds-1));
			
	}


}
		
